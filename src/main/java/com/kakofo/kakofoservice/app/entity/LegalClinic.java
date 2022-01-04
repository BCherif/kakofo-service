package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "legal_clinic")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegalClinic extends BaseEntity {
    private String name;
    private Integer targetWomen;
    private Integer targetMan;
    @Lob
    private String titleProject;
    @Lob
    private String headChiefContact;
    private String numberSubvention;
    private String address;
    private String email;
    private String numberPhone;
    private String typeOfServices;
    private Double longitude;
    private Double latitude;
}
