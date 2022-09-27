package com.Gu.cad.CadCli.controller;


import com.Gu.cad.CadCli.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getLogin(){
        return "loginIndex";
    }

    @PostMapping("/")
    public String login(@ModelAttribute(name="login") Login login, Model model){
        String email = login.getEmail();
        String senha = login.getSenha();

        if ("teste@teste.com".equals(email) && "123456".equals(senha) ){
            return "redirect:/client";
        }
        model.addAttribute("message", "Dados invalidos");
        return "loginIndex";

    }


}
