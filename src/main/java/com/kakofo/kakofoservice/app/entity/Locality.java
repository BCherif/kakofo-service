package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "locality")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Locality extends BaseEntity {
    private String name;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private Division division;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private Locality localitySup;

}
