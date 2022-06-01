package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity(name = "evento")
public class Evento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Size (max = 100)
    @NotNull
    private String nome;

    @NotNull
    private String hora;

    @NotNull
    private Date data;

    @NotNull
    private double preco;

    @ManyToMany
    @JoinTable(
            name = "evento_cliente",
            joinColumns = @JoinColumn(name = "evento_id",
                referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id",
                    referencedColumnName = "id")
    )

    private List<Cliente> clientes;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", hora=" + hora +
                ", data=" + data +
                ", preco=" + preco +
                '}';
    }
}
