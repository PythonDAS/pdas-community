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

    //aws mysql 한글입력 문제 해결해야 함.
    private String encodingUtf8(String str) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, "utf-8");
    }
}
