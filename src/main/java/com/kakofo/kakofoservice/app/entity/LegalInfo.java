package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "legal_info")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegalInfo extends BaseEntity {
    private String label;
    private String content;
}
