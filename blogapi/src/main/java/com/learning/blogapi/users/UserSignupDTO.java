package com.learning.blogapi.users;

import lombok.Data;

@Data
public class UserSignupDTO {
    String username;
    String email;
    String password;
    String bio;
}
