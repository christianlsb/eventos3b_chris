package br.senai.service.UserService;

import br.senai.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAllUsers();

    public ResponseUser isUserExist(User user);

    public User createUser(User user);

    public void deleteUser(User user);

    public Optional<User> findUserById(Long id);

    public User updateUser(User user);


}
