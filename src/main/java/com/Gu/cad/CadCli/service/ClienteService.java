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

    // getmaping (/clientes)
    public ModelAndView clientes(){

        final ModelAndView mv = new ModelAndView();
        mv.setViewName("cliente");
        mv.addObject("allcliente", repo.findAll());

        return mv;
    }


    public String createCliente(Model m){
        m.addAttribute("cliente", new Cliente());

        return "novo-cliente";
    }

    public String createCliente(Cliente cliente, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "novo-cliente";
        }

        repo.save(cliente);
        redirect.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        redirect.addFlashAttribute("message","Cliente cadastrado com sucesso!");

        return "redirect:/clientes";
    }

    public String deleteCliente(String id, RedirectAttributes rd){

        repo.deleteById(Long.parseLong(id));
        rd.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        rd.addFlashAttribute("message" , "Deletado Com Sucesso!");
        return  "redirect:/clientes";
    }





    public ModelAndView clienteById(long id) {

        final ModelAndView mv = new ModelAndView();
        mv.setViewName("alterarCliente");
        mv.addObject("cliente", repo.getById(id));

        return mv;
    }

    public String alterarCliente(Cliente cliente, BindingResult result, RedirectAttributes redirect, long id){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "alterarCliente";
        }

        repo.save(cliente);
        redirect.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        redirect.addFlashAttribute("message","Cliente atualizado com sucesso!");

        return "redirect:/clientes";
    }

}
