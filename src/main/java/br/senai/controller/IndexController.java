package br.senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }


    @GetMapping("/perfil")
    public  String perfil() {return "users/perfil";}

    @GetMapping("/favorito")
    public String favorito() {return "users/favorito";}

    @GetMapping("/home")
    public String home() {return "/home";}
}

