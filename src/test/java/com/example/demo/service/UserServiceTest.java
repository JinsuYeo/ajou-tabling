package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    void join() {

        User user1 = new User();
        user1.setName("kim");
        user1.setEmail("kim@ajou.ac.kr");

        User user2 = new User();
        user2.setName("kim");
        user2.setEmail("kim@naver.com");

        User user3 = new User();
        user3.setName("kim");
        user3.setEmail("kim@ajou.ac.kr");

        Long saveId = userService.join(user1);

        assertThat(user1).isEqualTo(userRepository.findOne(saveId));
        assertThatThrownBy(() -> userService.join(user2))
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> userService.join(user3))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void findUsers() {


    }

    @Test
    void findOne() {
    }
}