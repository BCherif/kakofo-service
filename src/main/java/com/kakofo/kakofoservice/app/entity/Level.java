package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "level")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Level extends BaseEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "cuttingId")
    private Cutting cutting;
    @ManyToOne
    @JoinColumn(name = "LevelSupId")
    private Level LevelSup;
}
