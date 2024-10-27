package com.example.agenda_thymeleaf.repositories;

import com.example.agenda_thymeleaf.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, String>{
}
