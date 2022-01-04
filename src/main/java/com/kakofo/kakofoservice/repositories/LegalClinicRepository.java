package com.kakofo.kakofoservice.repositories;

import com.kakofo.kakofoservice.app.entity.LegalClinic;
import com.kakofo.kakofoservice.app.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalClinicRepository extends JpaRepository<LegalClinic, Long> {
    LegalClinic findByName(String name);
}
