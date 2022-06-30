package br.com.split.repository;

import br.com.split.models.Role;
import br.com.split.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public List<Role> findByUserIn(Usuario ... Usuario);

}
