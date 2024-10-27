package com.example.agenda_thymeleaf.controllers;

import com.example.agenda_thymeleaf.entities.Funcionario;
import com.example.agenda_thymeleaf.services.EnderecoService;
import com.example.agenda_thymeleaf.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EnderecoService enderecoService;

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/funcionario")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Funcionario_Pagina");
        mv.addObject("ObjetoFuncionario", funcionarioService.findAll());
        return mv;
    }

    @GetMapping("/funcionario/add")
    public ModelAndView add(Funcionario funcionario) {
        ModelAndView mv = new ModelAndView("/FuncionarioAdd_Pagina");
        mv.addObject("ObjetoAddFuncionario", funcionario);
        mv.addObject("ObjetoEndereco", enderecoService.findAll());
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/funcionario/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {

        return add(funcionarioService.findOne(id).get());
    }

    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("/funcionario/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {

        funcionarioService.delete(id);

        return findAll();
    }

    @PostMapping("/funcionario/save")
    public ModelAndView save(Funcionario funcionario, BindingResult result) {

        if(result.hasErrors()) {
            return add(funcionario);
        }

        funcionarioService.save(funcionario);

        return findAll();
    }
}
