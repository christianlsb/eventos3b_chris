package br.com.split.services.userservice;

import br.com.split.models.Usuario;

import java.util.List;

public interface UserService {

    public List<Usuario> findAllUsers();

    public void createUser(Usuario user);


}
