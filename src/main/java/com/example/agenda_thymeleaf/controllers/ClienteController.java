package com.example.agenda_thymeleaf.controllers;

import com.example.agenda_thymeleaf.entities.Cliente;
import com.example.agenda_thymeleaf.entities.Funcionario;
import com.example.agenda_thymeleaf.services.ClienteService;
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
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/cliente")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Cliente_Pagina");
        mv.addObject("ObjetoCliente", clienteService.findAll());
        return mv;
    }

    @GetMapping("/cliente/add")
    public ModelAndView add(Cliente cliente) {
        ModelAndView mv = new ModelAndView("/ClienteAdd_Pagina");
        mv.addObject("ObjetoAddCliente", cliente);
        mv.addObject("ObjetoEndereco", enderecoService.findAll());
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/cliente/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {

        return add(clienteService.findOne(id).get());
    }

    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("/cliente/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {

        clienteService.delete(id);

        return findAll();
    }

    @PostMapping("/cliente/save")
    public ModelAndView save(Cliente cliente, BindingResult result) {

        if(result.hasErrors()) {
            return add(cliente);
        }

        clienteService.save(cliente);

        return findAll();
    }
}
