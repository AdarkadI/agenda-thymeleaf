package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_CLIENTE")
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    private String id_cliente;

    private String nome;

    private String telefone;

    private String email;

    @OneToOne
    private Endereco endereco;
}
