package com.example.agenda_thymeleaf.services;

import com.example.agenda_thymeleaf.entities.Servico;
import com.example.agenda_thymeleaf.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;
    //Retorna uma lista com todos posts inseridos

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Servico> findOne(String idServico) {
        return servicoRepository.findById(idServico);
    }

    //Salva ou atualiza um post
    public Servico save(Servico servico) {
        return servicoRepository.saveAndFlush(servico);
    }

    //Exclui um post
    public void delete(String idServico) {
        servicoRepository.deleteById(idServico);
    }
}
