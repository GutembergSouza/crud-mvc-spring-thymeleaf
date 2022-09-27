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


    /**
     *
     * @return page whit all registers of the database
     */
    @GetMapping("/client")
    public ModelAndView clients(){
        return service.clients();
    }

    /**
     * render the data entry page to the user input the register.
     * @param model m
     * @return
     */
    @GetMapping("/newClient")
    public String newCliente(Model model){
        return service.renderClient(model);
    }

     /**
     * SAVE a client received as a param
     * @param cliente
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping("/saveClient")
    public String saveCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes redirect){
        return service.save(cliente, result, redirect);
    }



    @GetMapping("/alterarCliente/{id}")
    public ModelAndView alterarCliente(@PathVariable(name="id") long id){

        return service.updateById(id);
    }

    @PostMapping("/alterarCliente/{id}")
    public String alterarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes redirect, @PathVariable long id){
        return service.save(cliente, result, redirect);
    }


    @GetMapping("/cliente/delete/{id}")
    public String deleteById(@PathVariable String id, RedirectAttributes rd) {
        return service.deleteCliente(id, rd);

    }



}
