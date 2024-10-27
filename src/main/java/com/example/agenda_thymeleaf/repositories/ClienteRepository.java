package com.example.agenda_thymeleaf.repositories;

import com.example.agenda_thymeleaf.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
