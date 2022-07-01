package br.com.spliteventos.component;

import br.com.spliteventos.models.Evento;
import br.com.spliteventos.services.eventoservice.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class CreateEvento implements CommandLineRunner {

    @Autowired
    private EventoServiceImpl eventoService;

    @Override
    public void run(String... args) throws Exception {
        Evento evento = new Evento();
        evento.setNome("Show Ivete Sangalo");
        evento.setDescription("Show da ivete sangalo venha curtir conosco, bora se divertir");
        evento.setData("22/08");
        evento.setLocal("Ratones");
        evento.setPreco(140.50);
        eventoService.createEvento(evento);
    }
}
