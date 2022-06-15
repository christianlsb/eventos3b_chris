package br.senai.service.EventoService;

import br.senai.model.Evento;
import br.senai.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public List< Evento > findAll() {
        return eventoRepository.findAll();
    }

    public Evento save(Evento evento){
        try {
            return eventoRepository.save(evento);
        } catch (Exception e){
            throw e;
        }

    }


    public void delete(Evento evento){
        eventoRepository.delete(evento);
    }


    @Override
    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }
}




