package com.example.agenda_thymeleaf.controllers;

import com.example.agenda_thymeleaf.entities.Endereco;
import com.example.agenda_thymeleaf.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/endereco")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Endereco_Pagina");
        mv.addObject("ObjetoEndereco", enderecoService.findAll());
        return mv;
    }

    @GetMapping("/endereco/add")
    public ModelAndView add(Endereco endereco) {
        ModelAndView mv = new ModelAndView("/EnderecoAdd_Pagina");
        mv.addObject("ObjetoAddEndereco", endereco);
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/endereco/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {

        return add(enderecoService.findOne(id).get());
    }

    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("/endereco/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {

        enderecoService.delete(id);

        return findAll();
    }

    @PostMapping("/endereco/save")
    public ModelAndView save(Endereco endereco, BindingResult result) {

        if(result.hasErrors()) {
            return add(endereco);
        }

        enderecoService.save(endereco);

        return findAll();
    }
}
