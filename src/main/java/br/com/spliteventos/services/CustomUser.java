package br.com.spliteventos.services;

import br.com.spliteventos.models.Evento;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class CustomUser extends User {

  private final String email;
  private final Long id;
  private final List<Evento> favoriteEventos;

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities, String email, Long id, List<Evento> favoriteEventos) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.email = email;
        this.id = id;
        this.favoriteEventos = favoriteEventos;
    }

    public String getEmail() {
        return email;
    }
}
