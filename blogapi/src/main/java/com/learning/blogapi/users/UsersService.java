package com.learning.blogapi.users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private List<UserEntity> usersList  = new ArrayList<>();

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public UserEntity createUser(String username, String email, String password,String bio){
            UserEntity userEntity = new UserEntity(username, email, password,bio);
            userEntity.setCreatedAt(new Date());
            usersList.add(userEntity);
            usersRepository.save(userEntity);
            //TODO:validate before adding/saving
                //    a. validate username min/max lenght
                //    b. hash the password
                //    c. validate email format
                //    d. validate entity not exist in database
            return userEntity;
    }
}
