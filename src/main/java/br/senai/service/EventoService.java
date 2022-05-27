package br.senai.service;
import br.senai.model.Cliente;
import br.senai.model.Evento;
import java.util.List;
import java.util.Optional;

public interface EventoService{
    public List<Evento> findAll();
    public Evento save(Evento evento);
    public void delete(Evento evento);
    public Optional<Evento> findById(Long id);
}
