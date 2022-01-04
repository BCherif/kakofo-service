package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "document")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document extends BaseEntity {
    private String name;
}
