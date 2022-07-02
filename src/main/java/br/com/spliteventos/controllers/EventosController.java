package br.com.spliteventos.controllers;

import br.com.spliteventos.services.eventoservice.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventosController {

    @Autowired
    private EventoServiceImpl eventoService;

    @GetMapping("/eventos")
    public String eventosPage(Model model, Authentication authentication){
        model.addAttribute("eventos", eventoService.findAllEventos());
        model.addAttribute("usuario", authentication.getPrincipal());
        return "evento/list.html";
    }

}
