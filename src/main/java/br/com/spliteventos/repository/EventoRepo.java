package br.com.spliteventos.repository;

import br.com.spliteventos.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {

    public Optional<Evento> findById(Long id);
}
