package com.kakofo.kakofoservice.app.repositories;

import com.kakofo.kakofoservice.app.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<News, Long> {
    Page<News> findAll(Pageable pageable);
}
