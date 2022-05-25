package br.senai.repository;

import br.senai.model.Cliente;
import br.senai.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository <Evento, Long> {
    @Override
    List< Evento > findAll();
    public Cliente findByData(Date Data);
    public Cliente findByHora(String Hora);
    public Cliente findByNome(String Nome);
    public Cliente findByPreco(Double preco);
}
