package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    @JoinColumn(name = "level_Id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Level level;
    private Double longitude;
    private Double latitude;
    private String type;
}
