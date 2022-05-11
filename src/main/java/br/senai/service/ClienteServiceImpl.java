package br.senai.service;

import br.senai.model.Cliente;
import br.senai.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll(Sort.by("nome"));
    }

    public Cliente save(Cliente cliente){
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e){
            throw e;
        }

    }

    public void delete(Cliente cliente){
        clienteRepository.delete(cliente);
    }


    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

}
