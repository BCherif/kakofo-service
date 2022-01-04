package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "category")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    private String name;
}
