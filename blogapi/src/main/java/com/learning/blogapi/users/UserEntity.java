package com.learning.blogapi.users;

import com.learning.blogapi.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@ToString
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true, length = 30)
    String username;
    @Column(nullable = false, unique = true, length = 50)
    String email;
    @Column(nullable = false)
    String password; //TODO : do not save password in plain text
    @Column
    String bio;

}
