package br.com.spliteventos.services.userservice;

import br.com.spliteventos.models.Usuario;

import java.util.List;

public interface UserService {

    public void createUsuario(Usuario usuario);

    public List<Usuario> findAllUsuarios();

}
