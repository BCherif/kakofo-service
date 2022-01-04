package com.kakofo.kakofoservice.app.entity;

import com.kakofo.kakofoservice.auth.entity.User;
import com.kakofo.kakofoservice.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "subscription")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription extends BaseEntity {
    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    private User user;

    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private LegalInfoCategory legalInfoCategory;
}
