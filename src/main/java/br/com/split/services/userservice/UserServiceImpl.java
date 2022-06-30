package br.com.split.services.userservice;

import br.com.split.models.Role;
import br.com.split.models.Usuario;
import br.com.split.repository.RoleRepository;
import br.com.split.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Este usuario não existe");
        }

        UserDetails userDetails = User.withUsername(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(authorities(usuario)).build();

        return userDetails;

    }

    public Collection<GrantedAuthority> authorities(Usuario usuario){
        Collection<GrantedAuthority> permissoes = new ArrayDeque<>();
        List<Role> roles = roleRepository.findByUserIn(usuario);
        for (Role roles_data : roles){
            permissoes.add(new SimpleGrantedAuthority(("ROLE_"+ roles_data.getRole_name())));
        }
        return permissoes;
    }



}
