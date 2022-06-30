package br.com.spliteventos.services.userservice;

import br.com.spliteventos.models.Usuario;
import br.com.spliteventos.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsuarioRepo usuarioRepo;


    @Override
    public void createUsuario(Usuario usuario) {

    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return null;
    }
}
