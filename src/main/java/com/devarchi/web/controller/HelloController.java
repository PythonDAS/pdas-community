package com.devarchi.web.controller;

import com.devarchi.web.command.MemberJoinRequest;
import com.devarchi.web.validator.MemberJoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by donghoon on 2016. 2. 14..
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String hello(Model model) {
        model.addAttribute("greeting", "안녕하세요!");
        return "hello";
    }

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
}
