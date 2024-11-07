package com.example.agenda_thymeleaf.controllers;

import com.example.agenda_thymeleaf.entities.Usuario;
import com.example.agenda_thymeleaf.services.TipoAcessoService;
import com.example.agenda_thymeleaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoAcessoService tipoAcessoService;

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/usuario")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/Usuario_Pagina");
        mv.addObject("ObjetoUsuario", usuarioService.findAll());
        return mv;
    }

    @GetMapping("/usuario/add")
    public ModelAndView add(Usuario usuario) {
        ModelAndView mv = new ModelAndView("/UsuarioAdd_Pagina");
        mv.addObject("ObjetoAddUsuario", usuario);
        mv.addObject("ObjetoTipoAcesso", tipoAcessoService.findAll());
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/usuario/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {

        return add(usuarioService.findOne(id).get());
    }

    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("/usuario/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {

        usuarioService.delete(id);

        return findAll();
    }

    @PostMapping("/usuario/save")
    public ModelAndView save(Usuario usuario, BindingResult result) {

        if(result.hasErrors()) {
            return add(usuario);
        }

        usuarioService.save(usuario);

        return findAll();
    }

    //Acessar a página de login
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("Login_Pagina"); //
    }

    //Validar se os dados inseridos
    @PostMapping("/validar-login")
    public ModelAndView validarLogin(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha) {
        // Chama o serviço para validar o login
        Optional<Usuario> usuarioOpt = usuarioService.validarLogin(usuario, senha);

        if (usuarioOpt.isPresent()) {
            // Se o usuário existir, vai para a agenda
            return new ModelAndView("redirect:/agenda");
        } else {
            // Dados incorretos, retorna à tela de login com um mensagem de erro
            ModelAndView mv = new ModelAndView("Login_Pagina");
            mv.addObject("erro", "Usuário ou senha inválidos.");
            return mv;
        }
    }



}
