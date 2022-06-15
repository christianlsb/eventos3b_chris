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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView addUser(@ModelAttribute User user, RedirectAttributes attributes){
        ResponseUser responseUser = new ResponseUser();
        try{
             userService.createUser(user);
             responseUser.setUser(user);
             responseUser.setExist(true);
             return new RedirectView("/home");
        }
        catch (Exception e){
            System.out.println(e);
            responseUser.setExist(false);
            attributes.addAttribute("isExist", responseUser.isExist());
            return new RedirectView("users/cadastro");
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
