package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_SERVICO")
@Getter
@Setter
public class Servico implements Serializable {
    @Id
    private String id_servico;

    private String nome;

    private double valor;
}
