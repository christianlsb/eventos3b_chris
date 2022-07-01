package br.com.spliteventos.services.userservice;

import br.com.spliteventos.controllers.FavoriteEvento;
import br.com.spliteventos.models.Usuario;

import java.util.List;

public interface UserService {

    public boolean createUsuario(Usuario usuario);

    public void favoriteEvent(FavoriteEvento favoriteEvento);

    public List<Usuario> findAllUsuarios();

}
