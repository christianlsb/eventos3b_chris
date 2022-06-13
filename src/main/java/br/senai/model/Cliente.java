package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotNull
    @Size(max = 100)
    private String username;

    @Size(max = 100)
    @NotNull
    private String email;


    @Size(max=100)
    @NotNull
    private String senha;


    @ManyToMany(mappedBy =  "clientes")
    private List<Evento> eventos;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evento> getEventos() {
        return eventos;
    }
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", username='   " + username + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}

