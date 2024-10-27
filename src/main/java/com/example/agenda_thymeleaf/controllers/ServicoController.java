package com.example.agenda_thymeleaf.controllers;

import com.example.agenda_thymeleaf.entities.Endereco;
import com.example.agenda_thymeleaf.entities.Servico;
import com.example.agenda_thymeleaf.services.EnderecoService;
import com.example.agenda_thymeleaf.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/servico")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Servico_Pagina");
        mv.addObject("ObjetoServico", servicoService.findAll());
        return mv;
    }

    @GetMapping("/servico/add")
    public ModelAndView add(Servico servico) {
        ModelAndView mv = new ModelAndView("/ServicoAdd_Pagina");
        mv.addObject("ObjetoAddServico", servico);
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/servico/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {

        return add(servicoService.findOne(id).get());
    }

    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("/servico/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {

        servicoService.delete(id);

        return findAll();
    }

    @PostMapping("/servico/save")
    public ModelAndView save(Servico servico, BindingResult result) {

        if(result.hasErrors()) {
            return add(servico);
        }

        servicoService.save(servico);

        return findAll();
    }
}
