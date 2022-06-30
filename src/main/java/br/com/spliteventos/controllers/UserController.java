package br.com.spliteventos.controllers;

import br.com.spliteventos.models.Usuario;
import br.com.spliteventos.services.userservice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/cadastro")
    public String cadastro(Model model){

        model.addAttribute("usuario", new Usuario());

        return "users/registrar.html";
    }

    @PostMapping("/createUser")
    public boolean createUsuario(@ModelAttribute Usuario usuario){
        try {
            userService.createUsuario(usuario);
            return true;
        }catch (Exception e){
            throw new IllegalArgumentException("Ocorreu um erro");
        }
    }


}
