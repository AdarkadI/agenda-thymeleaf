package com.example.agenda_thymeleaf.services;

import com.example.agenda_thymeleaf.entities.Funcionario;
import com.example.agenda_thymeleaf.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    //Retorna uma lista com todos posts inseridos

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Funcionario> findOne(String idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

    //Salva ou atualiza um post
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    //Exclui um post
    public void delete(String idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }
}
