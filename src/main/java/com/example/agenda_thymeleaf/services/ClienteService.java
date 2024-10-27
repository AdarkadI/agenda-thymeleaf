package com.example.agenda_thymeleaf.services;

import com.example.agenda_thymeleaf.entities.Cliente;
import com.example.agenda_thymeleaf.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    //Retorna uma lista com todos posts inseridos

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Cliente> findOne(String idCliente) {
        return clienteRepository.findById(idCliente);
    }

    //Salva ou atualiza um post
    public Cliente save(Cliente endereco) {
        return clienteRepository.saveAndFlush(endereco);
    }

    //Exclui um post
    public void delete(String idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
