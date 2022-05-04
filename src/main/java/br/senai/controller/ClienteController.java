package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     public String add(Model model){
        model.addAttribute("cliente", new Cliente());
        return "/cliente/adicionar-add";
    }

    @PostMapping("/cliente/save")
        public String save(Cliente cliente, Model model){
            try{
                clienteService.save(cliente);
                model.addAttribute("cliente", cliente);
                model.addAttribute("isSave", true);
                return "cliente/add";
            } catch (Exception e){
                model.addAttribute("cliente", cliente);
                model.addAttribute("isError", true);
                return "cliente/add";
            }
    }
}