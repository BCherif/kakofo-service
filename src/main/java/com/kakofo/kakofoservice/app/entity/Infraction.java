package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "infraction")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Infraction extends BaseEntity {
    private String label;
    private Integer amount;
    private String article;
    private String collector; //percepteur
    private String path;
}
