package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.model.User;
import br.senai.service.ClienteServiceImpl;
import br.senai.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/cadastro")
    public String cadastroPage(){
        return "users/registrar";
    }


    @GetMapping("/users/list")
    public ResponseEntity<List<User>> usersList(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/create_user")
    public ResponseEntity<String> addUser(@RequestBody User user){

        try{
             userService.create_user(user);
            return ResponseEntity.ok("true");
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.ok("false");
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginPage(){
        return ResponseEntity.ok("users/entrar");
    }

    @PostMapping("/login_verification")
    public ResponseEntity<String> loginVerification(){
        try {

        }
    }


}
