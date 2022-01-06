package com.kakofo.kakofoservice.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public class BaseEntity implements CEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "DATETIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    protected LocalDateTime createdAt = LocalDateTime.now();

    @CreatedBy
    @Column(name = "created_by")
    protected String createdBy;

    @LastModifiedDate
    @Column(name = "modified_at", columnDefinition = "DATETIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    protected LocalDateTime lastModifiedAt = LocalDateTime.now();


    @CreatedBy
    @Column(name = "modified_by")
    protected String lastModifiedBy;


    @Override
    public void setCreatedDate(LocalDate createdDate) {

    }

    @Override
    public void setCreatedTime(LocalTime createdTime) {

    }

    @Override
    public void setLastModifiedDate(LocalDate lastModifiedDate) {

    }

    @Override
    public void setLastModifiedTime(LocalTime lastModifiedTime) {

    }

//    @CreatedDate
//    @Column(name = "created_date", columnDefinition = "DATE")
//    protected LocalDate createdDate = LocalDate.now();
//
//    @CreatedDate
//    @Column(name = "created_time", columnDefinition = "TIME")
//    protected LocalTime createdTime = LocalTime.now();

//    @LastModifiedDate
//    @Column(name = "last_modified_date", columnDefinition = "DATE")
//    protected LocalDate lastModifiedDate = LocalDate.now();
//
//    @LastModifiedDate
//    @Column(name = "last_modified_time", columnDefinition = "TIME")
//    protected LocalTime lastModifiedTime = LocalTime.now();

}
