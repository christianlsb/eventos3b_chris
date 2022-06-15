package br.senai.controller;

import br.senai.service.UserService.ResponseUser;
import br.senai.model.User;
import br.senai.service.UserService.UserServiceImpl;
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


    @GetMapping("/list")
    public ResponseEntity<List<User>> usersList(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/users/cadastro")
    public String cadastroPage(@ModelAttribute User user){
        return "users/cadastro";
    }

    @PostMapping("/users/create_user")
    public ResponseEntity<ResponseUser> addUser(@ModelAttribute User user){
        ResponseUser responseUser = new ResponseUser();
        try{
             userService.createUser(user);
             responseUser.setUser(user);
             responseUser.setExist(true);
             return ResponseEntity.ok(responseUser);
        }
        catch (Exception e){
            System.out.println(e);
            responseUser.setExist(false);
            return ResponseEntity.ok(responseUser).;
        }
    }

    @GetMapping("/login")
    public String loginPage(){
        return "users/entrar";
    }

    @PostMapping("/login_verification")
    public ResponseEntity<ResponseUser> loginVerification(@RequestBody User user){
        return ResponseEntity.ok(userService.isUserExist(user));
    }




}
