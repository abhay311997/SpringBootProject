package com.learning.blogapi.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
public class UsersRepositoryTests {
    @Autowired private UsersRepository usersRepository;

    @Test
    public void createUser(){
        UserEntity userEntity  = new UserEntity(
                "abhay",
                "abhaytest2026@gmail.com",
                "abcd@#1234",
                "abhay user just a testcase"
        );
        var user = usersRepository.save(userEntity);
        Assertions.assertNotNull(user.getId());
        System.out.println(user.toString());
    }

    @Test
    public void findByUsername(){
        UserEntity userEntity1  = new UserEntity(
                "abhay1",
                "abhaytest2025@gmail.com",
                "abcd@#12345",
                "abhay is a user, just a testcase"
        );

        UserEntity userEntity2  = new UserEntity(
                "abhay2",
                "abhaytest2027@gmail.com",
                "abcd@#12346",
                "abhay is just a user, just a testcase"
        );

        usersRepository.save(userEntity1);
        usersRepository.save(userEntity2);

        var user1 = usersRepository.findByUsername("abhay1");
        var user2 = usersRepository.findByUsername("abhay2");

        Assertions.assertEquals("abhaytest2025@gmail.com", user1.getEmail());
        Assertions.assertEquals("abhaytest2028@gmail.com", user2.getEmail());

    }

}
