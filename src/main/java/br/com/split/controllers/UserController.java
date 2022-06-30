package br.com.split.controllers;

import br.com.split.models.Usuario;
import br.com.split.services.userservice.UserServiceImpl;
import org.hibernate.jdbc.Expectation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Future;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }
    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> userList(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/teste")
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("FUNCIONOU");
    }


    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody Usuario user){
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Usuario criado com sucesso");
        }
        catch (Exception e){
            throw new IllegalStateException("Ocorreu algum erro");
        }
    }





}
