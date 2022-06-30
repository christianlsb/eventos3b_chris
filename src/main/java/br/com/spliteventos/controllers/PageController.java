package br.com.spliteventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index.html";

    }

    @GetMapping("/login")
    public String login(){
        return "users/entrar.html";
    }

}
