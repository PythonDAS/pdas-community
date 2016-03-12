import com.devarchi.web.config.MvcConfig;
import com.devarchi.web.controller.MainController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

/**
 * Created by donghoon on 2016. 3. 13..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration
public class MainControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void userUrlTest() throws Exception {
        mockMvc.perform(get("/user")
                .header("x-requested-with", "XMLHttpReqeust")
                .accept(MediaType.ALL)
                .param("testKey", "testValue")
                .cookie(new Cookie("testKey1", "testValue1"))
                .cookie(new Cookie("testCookieKey2", "testCookieValue2"))
                .sessionAttr("testSessionKey", "testSessionValue"))
                .andExpect(handler().handlerType(MainController.class))
                .andExpect(handler().methodName("userData"))
                .andDo(MockMvcResultHandlers.print());

    }
}