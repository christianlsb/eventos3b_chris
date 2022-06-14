package br.senai.service;

import br.senai.model.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import br.senai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Argon2PasswordEncoder encoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean isUserExist(User user){
        boolean verify = false;
        for (User user_data : userRepository.findAll()){
            verify = user_data.getEmail().equals(user.getEmail()) &&
            user_data.getPassword().equals(user.getPassword());
        }
        return verify;
    }

    @Override
    public User create_user(User user) {
        try{
            String passwordEncoded  = encoder.encode(user.getPassword());
            user.setPassword(passwordEncoded);
            return userRepository.save(user);
        }
        catch (Exception e){
           throw e;
        }
    }

    @Override
    public void delete_user(User user) {
          userRepository.delete(user);
    }
}
