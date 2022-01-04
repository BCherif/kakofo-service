package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "util_Body")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtilBody extends BaseEntity {
    @Lob
    private String content;
}
