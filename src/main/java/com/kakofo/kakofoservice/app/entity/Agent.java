package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "agent")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agent extends BaseEntity {
    private String name;
}
