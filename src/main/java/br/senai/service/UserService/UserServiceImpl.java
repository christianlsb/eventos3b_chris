package br.senai.service.UserService;

import br.senai.model.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import br.senai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Verifica se o usuario está cadastrado no sistema
    @Override
    public ResponseUser isUserExist(User user){
        boolean verify = false;

        // Classe para fazer a validação do usuario
        ResponseUser responseUser = new ResponseUser();

        for (User user_data : userRepository.findAll()){

            boolean isPasswordExist = encoder.matches(user.getPassword(),
                    user_data.getPassword());

            responseUser.setExist(user_data.getEmail().equals(user.getEmail())
                    && isPasswordExist);

            if (responseUser.isExist()){
                responseUser.setUser(user_data);
                break;
            }

        }

        return responseUser;
    }

    @Override
    public User createUser(User user) {
        try{
            // Faz o Hash da senha do usuario
            String passwordEncoded  = encoder.encode(user.getPassword());

            user.setPassword(passwordEncoded);

            return userRepository.save(user);
        }
        catch (Exception e){
           throw e;
        }
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
