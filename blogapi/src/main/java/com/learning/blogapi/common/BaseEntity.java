package com.learning.blogapi.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    //@Column(nullable = false)
    UUID id;

    @CreatedDate
    //@Column(nullable = false)
    Date createdAt;

    protected void createDate(Date date) {
        this.createdAt = date ;
    }

    /* always create createdAt = new Date()
    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }
    }
     */
}
