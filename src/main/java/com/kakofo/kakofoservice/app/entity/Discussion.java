package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.auth.entity.User;
import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "discussion")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Discussion extends BaseEntity {
    @Lob
    private String content;
    private String type;
    @ManyToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    private User sender;

    @ManyToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    private User receiver;
}
