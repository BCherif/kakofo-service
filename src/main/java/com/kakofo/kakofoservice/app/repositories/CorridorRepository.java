package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.Corridor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridorRepository extends JpaRepository<Corridor, Long> {
    Corridor findByName(String name);
}
