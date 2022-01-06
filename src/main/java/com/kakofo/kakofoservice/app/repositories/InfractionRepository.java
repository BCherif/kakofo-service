package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InfractionRepository extends JpaRepository<Infraction, Long> {

    @Query("SELECT infraction FROM Infraction infraction WHERE infraction.id <> :id AND infraction.label = :label")
    List<Infraction> distinctByIdAndExistByLabel(@Param(value = "id") Long id, @Param(value = "label") String label);
}
