package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostesRepository extends JpaRepository<PoliceStation, Long> {
    PoliceStation findByName(String name);
}
