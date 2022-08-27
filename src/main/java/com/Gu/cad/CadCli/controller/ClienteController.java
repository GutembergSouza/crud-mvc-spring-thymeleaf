package com.Gu.cad.CadCli.controller;


import com.Gu.cad.CadCli.model.Cliente;
import com.Gu.cad.CadCli.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ClienteController {
    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public ModelAndView clientes(){
        return service.clientes();
    }

    @GetMapping("/novo-cliente")
    public String createCliente(Model model){
        return service.createCliente(model);
    }

    @PostMapping("/createCliente")
    public String createCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes redirect){
        return service.createCliente(cliente, result, redirect);
    }

    @GetMapping("/alterarCliente/{id}")
    public ModelAndView alterarCliente(@PathVariable(name="id") long id){

        return service.clienteById(id);
    }
    @PostMapping("/alterarCliente/{id}")
    public String alterarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes redirect, @PathVariable long id){
        return service.createCliente(cliente, result, redirect);
    }



    @GetMapping("/cliente/delete/{id}")
    public String deleteById(@PathVariable String id, RedirectAttributes rd) {
        return service.deleteCliente(id, rd);

    }



}
