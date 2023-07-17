package com.Security.TokenExam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/home")
    public String mainForm(){
        return "/Main";
    }
}
