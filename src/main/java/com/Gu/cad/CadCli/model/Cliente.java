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
    private String cpf;

    @Column
    private String rg;

    @Column
    private String dataDeNascimento;

    @Column
    private String email;

    @Column
    private String telefone;






}
