package br.senai.service.ClienteService;

import br.senai.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente save(Cliente cliente);
    public void delete(Cliente cliente);
    public Optional<Cliente> findById(Long id);



}



