package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "TB_TIPOACESSO")
@Getter
@Setter
public class TipoAcesso implements Serializable {
    @Id
    private String id_acesso;

    private String descricao;
}
