package br.com.split.services.userservice;

import br.com.split.models.Usuario;
import br.com.split.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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
            Usuario user_data = userRepository.findByUsername(user.getUsername());
            if (user_data == null){
                String userPassword = user.getPassword();
                String userEncodedPassoword = passwordEncoder.encode(userPassword);
                user.setPassword(userEncodedPassoword);
                userRepository.save(user);
            }

        }catch (Exception e){
            throw new IllegalStateException("This user already exists!");
        }
    }


}
