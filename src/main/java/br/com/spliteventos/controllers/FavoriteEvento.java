package br.com.spliteventos.controllers;

import br.com.spliteventos.models.Evento;
import org.springframework.security.core.Authentication;

public class FavoriteEvento {

    private Long evento_id;

    private String username;



    public Long getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Long evento_id) {
        this.evento_id = evento_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
