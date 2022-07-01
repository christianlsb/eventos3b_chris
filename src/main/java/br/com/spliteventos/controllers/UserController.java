package br.com.spliteventos.controllers;

import br.com.spliteventos.models.Usuario;
import br.com.spliteventos.services.userservice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity<Boolean> createUsuario(@RequestBody Usuario usuario){
        try {
            String userPass = usuario.getUser_password();
            String userEncodedPass = passwordEncoder.encode(userPass);
            usuario.setUser_password(userEncodedPass);
            return ResponseEntity.ok(userService.createUsuario(usuario));
        }catch (Exception e){
            throw new IllegalArgumentException("Ocorreu um erro");
        }
    }




}
