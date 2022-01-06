package com.kakofo.kakofoservice.base.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface CEntity extends Comparable<CEntity>, Serializable, Cloneable{
    Long getId();

    String getCreatedBy();

    String getLastModifiedBy();

    LocalDateTime getCreatedAt();

    LocalDateTime getLastModifiedAt();
//
//    LocalDate getCreatedDate();
//
//    LocalTime getCreatedTime();
//
//    LocalDate getLastModifiedDate();
//
//    LocalTime getLastModifiedTime();

    void setId(Long id);

    void setCreatedBy(String createdBy);

    void setLastModifiedBy(String lastModifiedBy);

    void setCreatedAt(LocalDateTime createdAt);

    void setLastModifiedAt(LocalDateTime lastModifiedAt);

    void setCreatedDate(LocalDate createdDate);

    void setCreatedTime(LocalTime createdTime);

    void setLastModifiedDate(LocalDate lastModifiedDate);

    void setLastModifiedTime(LocalTime lastModifiedTime);

    @Override
    default int compareTo(CEntity o) {
        if (o.getCreatedAt() == null || getCreatedAt() == null) return 0;
        return getCreatedAt().compareTo(o.getCreatedAt());
    }
}
