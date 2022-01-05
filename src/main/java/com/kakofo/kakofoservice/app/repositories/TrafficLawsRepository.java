package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.TrafficLaws;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficLawsRepository extends JpaRepository<TrafficLaws, Long> {
}
