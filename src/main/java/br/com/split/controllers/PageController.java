package br.com.split.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String index(){
        return "index.html";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "login.html";
    }



}
