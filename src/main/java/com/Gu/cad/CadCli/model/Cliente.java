package com.Gu.cad.CadCli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column
    @CPF(message = "CPF invalido!")
    private String cpf;

    @Column
    @Size(min = 3, max= 50, message = "Campo obrigatório")
    private String name;

    @Column
    private String dataDeNascimento;

    @Column
    @Email(message = "Email inválido!")
    @NotBlank(message = "* campo obrigatório")
    private String email;

    @Column
    @Size(min = 11, max = 11, message = "telefone invalido")
    private String telefone;






}
