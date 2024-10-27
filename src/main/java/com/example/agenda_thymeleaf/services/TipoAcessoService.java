package com.example.agenda_thymeleaf.services;

import com.example.agenda_thymeleaf.entities.TipoAcesso;
import com.example.agenda_thymeleaf.repositories.TipoAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAcessoService {

    @Autowired
    private TipoAcessoRepository tipoAcessoRepository;

    public List<TipoAcesso> findAll(){
        return tipoAcessoRepository.findAll();
    }

}
