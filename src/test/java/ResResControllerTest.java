import com.devarchi.web.config.MvcConfig;
import com.devarchi.web.controller.RestResController;
import com.devarchi.web.domain.social.Kakao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

/**
 * Created by donghoon on 2016. 3. 13..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration
public class ResResControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    private Kakao kakao;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

        kakao = new Kakao();
        kakao.setKakao_id(1);
        kakao.setProfile_img("dev_profile");
        kakao.setThumbnail_img("dev_thumbnail");
    }

    @Test
    public void checkKakaoIdTest() throws Exception {
        mockMvc.perform(post("/check_kakao_id")
                .param("kakao_id", "1")
                .sessionAttr("testSessionKey", "testSessionValue"))
                .andExpect(handler().handlerType(RestResController.class))
                .andExpect(handler().methodName("checKakaoId"))
                .andDo(MockMvcResultHandlers.print());
    }

}