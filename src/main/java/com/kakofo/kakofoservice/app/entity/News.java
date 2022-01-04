package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "news")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News extends BaseEntity {
    private String title;
    private String type;

    @Lob
    private String content;
    private String path;
    private Date date;
}
