package br.com.split.services.userservice;

import br.com.split.models.Usuario;
import br.com.split.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<Usuario> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(Usuario user) {

    }


}
