package br.senai.service;

import br.senai.model.Cliente;
import br.senai.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private Argon2PasswordEncoder encoder;
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll(Sort.by("nome"));
    }

    public Cliente save(Cliente cliente){
        try {
            String passwordEncoded  = encoder.encode(cliente.getSenha());
            cliente.setSenha(passwordEncoded);
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
