package br.senai.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class AddCliente implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {
//        Cliente cliente = new Cliente();
//        cliente.setUsername("TEAGO HENRIKE");
//        cliente.setEmail("teago@gmail.com");
//        cliente.setSenha("abc123456");
//
//        clienteService.save(cliente);
    }
}
