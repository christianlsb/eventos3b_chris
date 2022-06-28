package br.com.split.services.userservice;

import br.com.split.models.Usuario;
import br.com.split.repository.UserRepository;

import java.util.List;

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
        try{
          Usuario isUserExists = userRepository.findUserByUsername(user.getUsername());
          if (isUserExists == null){
              userRepository.save(user);
          }
        }
        catch (Exception e){
            throw new IllegalStateException("User already Exists");
        }
    }
}
