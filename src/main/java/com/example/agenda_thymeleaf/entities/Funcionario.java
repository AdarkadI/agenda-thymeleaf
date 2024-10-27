package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_FUNCIONARIO")
@Getter
@Setter
public class Funcionario implements Serializable {
    @Id
    private String id_funcionario;

    private String nome;

    private String telefone;

    private String email;

    private double salario;

    @ManyToOne
    private Endereco endereco;
}
