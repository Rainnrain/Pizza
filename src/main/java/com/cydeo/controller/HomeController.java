package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @GetMapping("")
//    public String home(){
//        return "home";
//    }

    @GetMapping({"/home", "/"})
    public String home2(){
        return "home";
    }
}
