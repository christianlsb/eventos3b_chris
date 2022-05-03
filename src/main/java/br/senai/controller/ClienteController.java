package br.senai.controller;

import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/cliente/list")
    public String findAll(Model model){
        System.out.println(clienteService.findAll());

        return "cliente/list";
    }

    @GetMapping("/cliente/adicionar-add")
     public String add(){

        return "/cliente/adicionar-add";
    }

}
