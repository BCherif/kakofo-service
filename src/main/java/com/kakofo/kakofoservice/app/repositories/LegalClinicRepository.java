package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.LegalClinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalClinicRepository extends JpaRepository<LegalClinic, Long> {
    LegalClinic findByName(String name);
}
