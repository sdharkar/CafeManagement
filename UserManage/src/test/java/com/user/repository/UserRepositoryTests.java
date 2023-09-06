package com.user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.user.model.User;

@DataMongoTest
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("nam2020");

        User newUser = new User("nam@codejava.net", password, password, password, password, password, null);
        User savedUser = repo.save(newUser);

//        assertThat(savedUser).isNotNull();
//        assertThat(savedUser.getId()).isNotNull();
    }
}
