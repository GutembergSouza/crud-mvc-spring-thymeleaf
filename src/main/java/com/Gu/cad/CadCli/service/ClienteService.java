package com.Gu.cad.CadCli.service;

import com.Gu.cad.CadCli.model.Cliente;
import com.Gu.cad.CadCli.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.tags.HtmlEscapeTag;
import org.w3c.dom.html.HTMLDivElement;
import org.w3c.dom.html.HTMLElement;

import javax.swing.text.html.HTML;

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
        rd.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        redirect.addFlashAttribute("message","Cliente cadastrado com sucesso!");

        return "redirect:/";
    }

    public String deleteCliente(String id, RedirectAttributes rd){

        repo.deleteById(Long.parseLong(id));
        rd.addFlashAttribute("alertClass","alert-success  alert-dismissible ");
        rd.addFlashAttribute("message" , "Deletado Com Sucesso!");
        return  "redirect:/";
    }




    public ModelAndView alterarCliente(){
        final ModelAndView mv = new ModelAndView();
        mv.setViewName("alterar-cliente");
        return mv;
    }

    public String alterarCliente(Model m){
        m.addAttribute("cliente", new Cliente());

        return "alterar-cliente";
    }





}
