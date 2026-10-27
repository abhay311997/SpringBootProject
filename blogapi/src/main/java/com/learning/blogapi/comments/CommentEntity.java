package com.learning.blogapi.comments;

import com.learning.blogapi.articles.ArticleEntity;
import com.learning.blogapi.common.BaseEntity;
import com.learning.blogapi.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity(name = "comments")
public class CommentEntity extends BaseEntity {
    @Column(nullable = false,length = 100)
    String title;
    @Column(nullable = false, length = 1000)
    String body;

    @ManyToOne
    UserEntity author;

    @ManyToOne
    ArticleEntity article;
}
