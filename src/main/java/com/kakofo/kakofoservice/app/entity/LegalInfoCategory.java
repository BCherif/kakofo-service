package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "legal_info_category")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegalInfoCategory extends BaseEntity {
    private String label;
}
