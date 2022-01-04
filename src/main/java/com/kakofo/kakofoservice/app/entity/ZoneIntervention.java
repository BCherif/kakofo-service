package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "zone_intervention")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZoneIntervention extends BaseEntity {
    @OneToOne
    private Level level;
    @OneToOne
    private LegalClinic legalClinic;
}
