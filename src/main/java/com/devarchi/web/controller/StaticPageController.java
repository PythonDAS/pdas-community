package com.devarchi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by donghoon on 2016. 3. 11..
 */
@Controller
public class StaticPageController {
    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/resources/pages/pythondas-homepage/index.html";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "redirect:/resources/pages/login.html";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "redirect:/resources/pages/register.html";
    }

}