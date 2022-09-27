package com.Gu.cad.CadCli.service;

import com.Gu.cad.CadCli.model.Cliente;
import com.Gu.cad.CadCli.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    /**
     * return all clients to table at main page
     * @return
     */
    public ModelAndView clients(){

        final ModelAndView mv = new ModelAndView();
        mv.setViewName("client");
        mv.addObject("allcliente", repo.findAll());

        return mv;
    }

    /**
     * Render a model for the entry page to inut of data.
     * @param  m
     * @return
     */
    public String renderClient(Model m){
        m.addAttribute("cliente", new Cliente());

        return "newClient";
    }

    /**
     * save a client received as a parameter
     * @param cliente
     * @param result
     * @param redirect
     * @return
     */
    public String save(Cliente cliente, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            redirect.addFlashAttribute("alertClass","alert-error  alert-dismissible ");
            redirect.addFlashAttribute("message","Cliente nao cadastrado!");
            return "newClient";
        }

        repo.save(cliente);
        redirect.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        redirect.addFlashAttribute("message","Cliente cadastrado com sucesso!");

        return "redirect:/client";
    }

    public String deleteCliente(String id, RedirectAttributes rd){

        repo.deleteById(Long.parseLong(id));
        rd.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        rd.addFlashAttribute("message" , "Deletado Com Sucesso!");
        return  "redirect:/client";
    }





    public ModelAndView updateById(long id) {

        final ModelAndView mv = new ModelAndView();
        mv.setViewName("updateClient");
        mv.addObject("cliente", repo.getById(id));

        return mv;
    }

    /*public String alterarCliente(Cliente cliente, BindingResult result, RedirectAttributes redirect, long id){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "updateClient";
        }

        repo.save(cliente);
        redirect.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        redirect.addFlashAttribute("message","Cliente atualizado com sucesso!");

        return "redirect:/client";
    }*/

}
