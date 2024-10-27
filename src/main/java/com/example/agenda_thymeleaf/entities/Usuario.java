package com.example.agenda_thymeleaf.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
public class Usuario implements Serializable {
    @Id
    private String id_usuario;

    private String usuario;

    private String senha;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtCadastro;

    @ManyToOne
    private TipoAcesso tipoAcesso;
}
