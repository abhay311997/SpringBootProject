package com.learning.blogapi.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService ;

    public UsersController(UsersService usersService){
        this.usersService = usersService ;
    }

    @PostMapping("/signup")
    ResponseEntity<UserEntity> signupUser(@RequestBody UserSignupDTO userSignupDTO) {
        var user = usersService.createUser(userSignupDTO.username, userSignupDTO.email, userSignupDTO.password,userSignupDTO.bio);
        return ResponseEntity.ok(user);
    }
}
