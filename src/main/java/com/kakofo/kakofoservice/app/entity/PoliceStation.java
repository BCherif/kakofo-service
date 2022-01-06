package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "police_station")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PoliceStation extends BaseEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "locality", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Locality locality;
    private Double longitude;
    private Double latitude;
    @ManyToOne
    private TypePoste type;
}
