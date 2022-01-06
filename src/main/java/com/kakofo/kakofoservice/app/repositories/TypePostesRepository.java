package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.PoliceStation;
import com.kakofo.kakofoservice.app.entity.TypePoste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePostesRepository extends JpaRepository<TypePoste, Long> {
    TypePoste findByName(String name);
}
