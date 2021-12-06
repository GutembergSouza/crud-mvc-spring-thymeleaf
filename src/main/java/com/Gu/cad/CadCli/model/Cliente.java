package com.Gu.cad.CadCli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column
    private String empresa;

    @Column
    private String cnpj;

    @Column
    private String e_cac;

    @Column
    private String n_social;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String dataDeNascimento;

    @Column
    private String tituloDeEleitor;


    @Column
    private String rua;

    @Column
    private String numero;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private String cep;

    @Column
    private String email;

}
