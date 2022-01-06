package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.Division;
import com.kakofo.kakofoservice.app.entity.TypePoste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
