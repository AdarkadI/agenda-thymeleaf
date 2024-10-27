package com.example.agenda_thymeleaf.services;

import com.example.agenda_thymeleaf.entities.Usuario;
import com.example.agenda_thymeleaf.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Retorna uma lista com todos posts inseridos
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Usuario> findOne(String idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    //Salva ou atualiza um post
    public Usuario save(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    //Exclui um post
    public void delete(String idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
