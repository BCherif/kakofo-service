package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.Locality;
import com.kakofo.kakofoservice.app.entity.TypePoste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalityRepository extends JpaRepository<Locality, Long> {

    @Query("SELECT l FROM Locality l WHERE  l.division.id = :divisionId")
    List<Locality> getLocalitiesByDivision(Long divisionId);

    @Query("SELECT l FROM Locality l WHERE  l.localitySup.id = :localitySupId")
    List<Locality> getLocalitiesByLocalitySup(Long localitySupId);
}
