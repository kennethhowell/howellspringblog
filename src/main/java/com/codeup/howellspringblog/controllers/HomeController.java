package com.codeup.howellspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

//    @ResponseBody
//    public String landingGreeting(){
//        return "Welcome to my blog! Woot!";
//    }


}
