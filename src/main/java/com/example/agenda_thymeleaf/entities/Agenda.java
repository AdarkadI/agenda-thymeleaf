package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "TB_AGENDA")
@Getter
@Setter
public class Agenda implements Serializable {
    @Id
    private String id_agenda;

    private String descricao;

    private Date data;

    private String status;

   @OneToOne
    private Servico servico;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Funcionario funcionario;
}
