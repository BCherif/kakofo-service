package com.kakofo.kakofoservice.repositories;

import com.kakofo.kakofoservice.app.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostesRepository extends JpaRepository<PoliceStation, Long> {
    PoliceStation findByName(String name);
}
