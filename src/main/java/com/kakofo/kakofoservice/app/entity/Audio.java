package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "audio")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Audio extends BaseEntity {
    private String pathAudio;
    @ManyToOne
    @JoinColumn(name = "document")
    private Document document;
}
