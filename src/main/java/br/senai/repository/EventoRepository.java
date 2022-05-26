package br.senai.repository;

import br.senai.model.Cliente;
import br.senai.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository <Evento, Long> {
    @Override
    List< Evento > findAll();
    public Evento findByData(Date Data);
    public Evento findByHora(String Hora);
    public Evento findByNome(String Nome);
    public Evento findByPreco(double preco);
}
