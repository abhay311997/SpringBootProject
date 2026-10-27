package com.learning.blogapi.articles;

import com.learning.blogapi.common.BaseEntity;
import com.learning.blogapi.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {
    @Column(nullable = false, length = 100)
    String title; //Ex- How To Live In Pressure
    @Column(nullable = false, length = 80)
    String slug; //Ex- how-to-live-in-pressure
    @Column(length = 200)
    String subtitle;
    @Column(nullable = false, length = 5000)
    String body;

    @ManyToOne
    UserEntity author;
}
