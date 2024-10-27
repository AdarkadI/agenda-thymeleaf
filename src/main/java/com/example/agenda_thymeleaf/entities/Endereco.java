package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_ENDERECO")
@Getter
@Setter
public class Endereco implements Serializable {
    @Id
    private String id_endereco;

    private String logradouro;

    private String UF;

    private String estado;

    private String cep;

    private String cidade;

    private int numero;

    private String complemento;
}
