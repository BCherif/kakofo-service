package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<News, Long> {
}
