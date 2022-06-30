package br.com.spliteventos.services.eventoservice;

import br.com.spliteventos.models.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    public List<Evento> findAllEventos();

    public void createEvento(Evento evento);

    public void deleteEvento(Evento evento);



}
