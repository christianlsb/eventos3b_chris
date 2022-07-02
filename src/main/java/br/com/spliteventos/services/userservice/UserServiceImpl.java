package br.com.spliteventos.services.userservice;

import br.com.spliteventos.controllers.FavoriteEvento;
import br.com.spliteventos.models.Evento;
import br.com.spliteventos.models.Role;
import br.com.spliteventos.models.Usuario;
import br.com.spliteventos.repository.EventoRepo;
import br.com.spliteventos.repository.RoleRepo;
import br.com.spliteventos.repository.UsuarioRepo;
import br.com.spliteventos.services.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EventoRepo eventoRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public boolean createUsuario(Usuario usuario) {
        boolean isCreated = false;
        try {
            Usuario user_data = usuarioRepo.findUserByUsername(usuario.getUsername());
            if (user_data == null){
                usuario.setPermissions(Arrays.asList(roleRepo.findByNome("USER")));
                usuarioRepo.save(usuario);
                isCreated = true;

            }

        }catch (Exception e){
            throw new IllegalStateException("User already exists");
        }
        return isCreated;
    }

    @Override
    public boolean favoriteEvent(FavoriteEvento favoriteEvento) {
        boolean isFavorited = false;
        Usuario user_data = usuarioRepo.findUserByUsername(favoriteEvento.getUsername());
        Optional<Evento> evento_data = eventoRepo.findById(favoriteEvento.getEvento_id());

        if (user_data != null){
            user_data.getFavoriteEvents().add(evento_data.get());
            usuarioRepo.save(user_data);
            isFavorited = true;
        }


        return isFavorited;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user_data = usuarioRepo.findUserByUsername(username);
        if(user_data == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        CustomUser customUser = new CustomUser(username, user_data.getUser_password(),
                true, true,true, true,
                authorities(user_data), user_data.getEmail(), user_data.getId(), user_data.getFavoriteEvents());

        UserDetails userDetails = customUser;


        return userDetails;
    }

    public Collection<GrantedAuthority> authorities(Usuario usuario){
        Collection<GrantedAuthority> permissoes = new ArrayDeque<>();
        List<Role> roles = roleRepo.findByUsuariosIn(usuario);
        for (Role role : roles){
            permissoes.add(new SimpleGrantedAuthority(("ROLE_" + role.getNome())));
        }
        return permissoes;

    }







}
