package br.senai.service;

import br.senai.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAllUsers();

    public boolean isUserExist(User user);
    public User create_user(User user);

    public void delete_user(User user);


}
