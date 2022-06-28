package br.com.split.repository;

import br.com.split.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findUserByEmail(String email);

}
