package br.com.spliteventos.repository;

import br.com.spliteventos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    public Usuario findUserByUsername(String username);




}
