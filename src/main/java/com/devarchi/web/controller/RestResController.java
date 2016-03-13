package com.devarchi.web.controller;

import com.devarchi.web.dao.mybatis.KakaoDao;
import com.devarchi.web.domain.social.Kakao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by donghoon on 2016. 3. 13..
 */
@RestController
public class RestResController {
    private static final Logger logger = LoggerFactory.getLogger(RestResController.class);

    @Autowired
    private KakaoDao kakaoDao;

    @RequestMapping(value = "check_kakao_id", method = RequestMethod.POST)
    public String checKakaoId(String kakao_id) {
        try {
            Integer castKakaoId = Integer.parseInt(kakao_id);
            kakaoDao.exist(castKakaoId).getKakao_id(); //null pointer exception check 필요함.
        } catch (NullPointerException e) {
            //null 이면 kakao info insert 후 profile 페이지 이동.
            logger.debug("최초 로그인!");
            return "NOTEXISTID";
        }
        //null 이 아니면 profile 페이지 이동.
        logger.debug("이미 가입한 회원!");
        return "EXISTID";
    }

    @RequestMapping(value = "insert_kakao_info", method = RequestMethod.POST)
    public String checKakaoId(@ModelAttribute Kakao kakao) {
        try {
            kakaoDao.insertKakaoInfo(kakao); //null pointer exception check 필요함.
        } catch (NullPointerException e) {
            //null 이면 error message return.
            return e.getMessage();
        }
        //null 이 아니면 welcome return.
        return "Welcome";
    }

    //aws mysql 한글입력 문제 해결해야 함.
    private String encodingUtf8(String str) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, "utf-8");
    }
}
