package com.example.agenda_thymeleaf.repositories;

import com.example.agenda_thymeleaf.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, String> {
}
