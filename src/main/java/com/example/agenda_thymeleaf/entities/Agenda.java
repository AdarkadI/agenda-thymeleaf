package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    private String status;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Funcionario funcionario;
}
