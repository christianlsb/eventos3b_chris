package br.com.split.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ClienteList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotNull
    @NotEmpty
    private String cliente_name;

    public ClienteList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente_name() {
        return cliente_name;
    }

    public void setCliente_name(String cliente_name) {
        this.cliente_name = cliente_name;
    }

    @Override
    public String toString() {
        return "ClienteList{" +
                "id=" + id +
                ", cliente_name='" + cliente_name + '\'' +
                '}';
    }
}
