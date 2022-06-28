package br.com.split.services;

import br.com.split.models.Usuario;
import br.com.split.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutheticationService implements UserDetailsService {

    private final UserRepository userRepository;

    public AutheticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> opt = userRepository.findUserByEmail(email);
        if (opt.isPresent()){
            return opt.get();
        }
        throw new UsernameNotFoundException("Account unexistent!!!");
    }
}
