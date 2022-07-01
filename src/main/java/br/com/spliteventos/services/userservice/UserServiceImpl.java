package br.com.spliteventos.services.userservice;

import br.com.spliteventos.models.Role;
import br.com.spliteventos.models.Usuario;
import br.com.spliteventos.repository.RoleRepo;
import br.com.spliteventos.repository.UsuarioRepo;
import br.com.spliteventos.services.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private RoleRepo roleRepo;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean createUsuario(Usuario usuario) {
        boolean isCreated = false;
        try {
            Usuario user_data = usuarioRepo.findUserByUsername(usuario.getUsername());
            if (user_data == null){
//                String userPassword = usuario.getUser_password();
//                String userPasswordEncoded = passwordEncoder.encode(userPassword);
//                usuario.setUser_password(userPasswordEncoded);
                usuario.setPermissions(Arrays.asList(roleRepo.findByNome("USER")));
                System.out.println("PASSOU");
                usuarioRepo.save(usuario);
                isCreated = true;

            }

        }catch (Exception e){
            throw new IllegalStateException("User already exists");
        }
        return isCreated;
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
                authorities(user_data), user_data.getEmail());

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
