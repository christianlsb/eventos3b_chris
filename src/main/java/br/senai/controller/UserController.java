package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/cadastro")
    public String cadastroPage(){
        return "users/registrar";
    }

    @PostMapping("/create_user")
    public ResponseEntity<String> addUser(@ModelAttribute Cliente cliente){

        try{
            clienteService.save(cliente);
        }
        catch (Exception e){
            throw new IllegalArgumentException("DEU RUIM \n" + e);
        }

        return ResponseEntity.ok("Ok");
    }



}
