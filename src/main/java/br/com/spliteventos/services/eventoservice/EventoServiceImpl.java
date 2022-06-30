package br.com.spliteventos.services.eventoservice;

import br.com.spliteventos.models.Evento;
import br.com.spliteventos.repository.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepo eventoRepo;

    @Override
    public List<Evento> findAllEventos() {
        return eventoRepo.findAll();
    }

    @Override
    public void createEvento(Evento evento) {
        try{
            eventoRepo.save(evento);
        }
        catch (Exception e){
            throw new IllegalStateException("An error ocurred in the creation of event");
        }
    }

    @Override
    public void deleteEvento(Evento evento) {

    }
}
