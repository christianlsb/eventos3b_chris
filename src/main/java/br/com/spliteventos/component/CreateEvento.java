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
//        Evento evento = new Evento();
//        evento.setNome("Festa Ivete Sangalo");
//        evento.setDescription("Show da ivete sangalo venha curtir conosco, bora se divertir");
//        evento.setData("22/08");
//        evento.setLocal("Ratones");
//        evento.setPreco(140.50);
//        eventoService.createEvento(evento);
//
//        Evento evento1 = new Evento();
//        evento1.setNome("Loud game vs imperial kkkk");
//        evento1.setDescription("Pentakill de master yi top");
//        evento1.setData("22/08");
//        evento1.setLocal("Ratones");
//        evento1.setPreco(140.50);
//        eventoService.createEvento(evento1);

//        Evento evento2 = new Evento();
//        evento2.setNome("CS WORLD CHAMPIONS");
//        evento2.setDescription("A CHAMPIONATE OF CSGO WITH THE BETTER PLAYERS IN THE WORLD");
//        evento2.setData("22/08");
//        evento2.setLocal("Ratones");
//        evento2.setPreco(140.50);
//        eventoService.createEvento(evento2);
    }
}
