package com.example.agenda_thymeleaf.controllers;

import com.example.agenda_thymeleaf.entities.Agenda;
import com.example.agenda_thymeleaf.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/")
    public ModelAndView findAll2() {
        ModelAndView mv = new ModelAndView("/Neanderagenda_pagina");
        return mv;
    }

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/agenda")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Agenda_Pagina");
        mv.addObject("ObjetoAgenda", agendaService.findAll());
        return mv;
    }

    @GetMapping("/agenda/add")
    public ModelAndView add(Agenda agenda) {
        ModelAndView mv = new ModelAndView("/AgendaAdd_Pagina");
        mv.addObject("ObjetoAddAgenda", agenda);
        mv.addObject("ObjetoServico", servicoService.findAll());
        mv.addObject("ObjetoCliente", clienteService.findAll());
        mv.addObject("ObjetoUsuario", usuarioService.findAll());
        mv.addObject("ObjetoFuncionario", funcionarioService.findAll());
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/agenda/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {

        return add(agendaService.findOne(id).get());
    }

    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("/agenda/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {

        agendaService.delete(id);

        return findAll();
    }

    @PostMapping("/agenda/save")
    public ModelAndView save(Agenda agenda, BindingResult result) {

        if(result.hasErrors()) {
            return add(agenda);
        }

        agendaService.save(agenda);

        return findAll();
    }
}
