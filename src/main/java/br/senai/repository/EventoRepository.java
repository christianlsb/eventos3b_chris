package br.senai.repository;

import br.senai.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository <Evento, Long> {
    @Override
    List<Evento> findAll();
}
