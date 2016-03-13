package com.devarchi.web.controller;

import com.devarchi.web.dao.mybatis.KakaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by donghoon on 2016. 3. 13..
 */
@RestController
public class RestResController {

    @Autowired
    private KakaoDao kakaoDao;

    @RequestMapping(value = "check_kakao_id")
    public String checKakaoId(String kakao_id) {
        Integer castKakaoId = Integer.parseInt(kakao_id);
        Integer getKakaId = kakaoDao.exist(castKakaoId).getKakao_id(); //null pointer exception check 필요함.

        if (getKakaId != null) {
            return "EXISTID";
        }

        return "NOTEXISTID";
    }

}
