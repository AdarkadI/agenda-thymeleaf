package com.example.agenda_thymeleaf.repositories;

import com.example.agenda_thymeleaf.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
}
