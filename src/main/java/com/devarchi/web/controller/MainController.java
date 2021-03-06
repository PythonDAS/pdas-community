package com.devarchi.web.controller;

import com.devarchi.web.command.MemberJoinRequest;
import com.devarchi.web.dao.mybatis.KakaoDao;
import com.devarchi.web.dao.mybatis.SkillDao;
import com.devarchi.web.dao.mybatis.UserDao;
import com.devarchi.web.domain.social.Kakao;
import com.devarchi.web.validator.MemberJoinValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by donghoon on 2016. 2. 14..
 */
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private SkillDao skillDao;
    @Autowired
    private KakaoDao kakaoDao;

    //test 용도.
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("greeting", "안녕하세요!");
        return "hello";
    }

    //test 용도.
    @RequestMapping(value = "/member")
    public String member(Model model,
                         @ModelAttribute("memberJoin") MemberJoinRequest memberJoinRequest,
                         BindingResult bindingResult) {
        new MemberJoinValidator().validate(memberJoinRequest, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("member", "회원가입이 실패 하였습니다!");
            return "member";
        }

        System.out.println("Email: " + memberJoinRequest.getEmail());
        System.out.println("Name: " + memberJoinRequest.getName());
        System.out.println("Pass: " + memberJoinRequest.getPass());
        System.out.println("Confirm Pass: " + memberJoinRequest.getConfirmPass());

        model.addAttribute("member", "회원가입이 성공 하였습니다!");
        return "member";
    }

    //test 용도.
    @RequestMapping(value = "/user")
    public String userData(Model model) {
        Thread thread = Thread.currentThread();
        model.addAttribute("count", userDao.count());
        model.addAttribute("userList", userDao.find());
        model.addAttribute("user", userDao.findByName("donghoon"));
        model.addAttribute("count_skill", skillDao.count());
        model.addAttribute("skillList", skillDao.find());
        model.addAttribute("skillListByName", skillDao.findSkillByName("donghoon"));
        model.addAttribute("currentThread", thread);
        return "user";
    }

    //main profile page.
    @RequestMapping(value = "/resources/pages/profile", method = RequestMethod.POST)
    public String profilePage(Model model, @ModelAttribute Kakao kakao) {
        logger.debug("메인 프로필 페이지!");

        //kakao 이외의 방법으로 로그인 시 로직 구현 할 부분.
        if (kakao == null) {
            return "profile";
        }

        //kakao 로 로그인 유저 로직.
        model.addAttribute("kakaoInfo", kakao);

        Integer kakaoId = kakao.getKakao_id();

        Integer existUser = kakaoDao.exist(kakaoId);
        logger.debug("First login user by kakao: " + existUser);

        if (existUser != null) {
            // 이미 로그인 했던 유저는 바로 뷰 리턴.
            logger.debug("이미 회원임.");
            return "profile";
        } else {
            // 최초 로그인 유저는 kakao 정보 저장후 뷰 리턴.
            logger.debug("처음 방문함.");
            kakaoDao.insertKakaoInfo(kakao);
            return "profile";
        }

    }

    private Integer paramStringToInteger(String param) {
        return Integer.parseInt(param);
    }
}
