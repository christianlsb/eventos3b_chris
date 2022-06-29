package br.com.split.component;

import br.com.split.models.Usuario;
import br.com.split.services.userservice.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class CreateUsers implements CommandLineRunner {

    private final UserServiceImpl userService;

    public CreateUsers(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
//       Usuario eduardo = new Usuario();
//
//       eduardo.setReal_name("Eduardo Paixão");
//       eduardo.setUsername("Eduardo668");eduardo.setPassword("abc12345");
//       eduardo.setEmail("eduardosehn20@gmail.com");
//
//        userService.createUser(eduardo);
    }
}
