package com.example.agenda_thymeleaf.services;

import com.example.agenda_thymeleaf.entities.Endereco;
import com.example.agenda_thymeleaf.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    //Retorna uma lista com todos posts inseridos

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Endereco> findOne(String idFuncionario) {
        return enderecoRepository.findById(idFuncionario);
    }

    //Salva ou atualiza um post
    public Endereco save(Endereco endereco) {
        return enderecoRepository.saveAndFlush(endereco);
    }

    //Exclui um post
    public void delete(String idEndereco) {
        enderecoRepository.deleteById(idEndereco);
    }
}
