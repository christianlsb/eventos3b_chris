package br.com.spliteventos.repository;

import br.com.spliteventos.models.Role;
import br.com.spliteventos.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    public List<Role> findByUsuariosIn(Usuario ... usuarios);

    public Role findByNome(String role_name);

}
