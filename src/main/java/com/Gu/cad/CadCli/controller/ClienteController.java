package com.Gu.cad.CadCli.controller;


import com.Gu.cad.CadCli.model.Cliente;
import com.Gu.cad.CadCli.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ClienteController {
    @Autowired
    ClienteService service;

    @GetMapping("")
    public ModelAndView clientes(){
        return service.clientes();
    }

    @GetMapping("/novo-cliente")
    public String createCliente(Model model){
        return service.createCliente(model);
    }

    @PostMapping("/cliente")
    public String createCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes redirect){
        return service.createCliente(cliente, result, redirect);
    }

    @GetMapping("/alterar-cliente")
    public ModelAndView alterarCliente(){
        return service.alterarCliente();
    }

    @GetMapping("/remover-cliente")
    public ModelAndView removerCliente(){
        return service.removerCliente();
    }





}
