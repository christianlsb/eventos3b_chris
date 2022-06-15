package br.senai.controller;

import br.senai.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/home")
    public String index(){

        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

}
