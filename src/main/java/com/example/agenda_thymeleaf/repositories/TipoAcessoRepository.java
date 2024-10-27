package com.example.agenda_thymeleaf.repositories;

import com.example.agenda_thymeleaf.entities.TipoAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAcessoRepository extends JpaRepository<TipoAcesso, String> {
}
