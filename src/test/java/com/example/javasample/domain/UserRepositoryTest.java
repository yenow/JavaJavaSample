package com.example.javasample.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    @Transactional
    void testUser() {
        // given
        User user = new User();
        user.setUsername("userA");

        // when
        Long saveId = userRepository.save(user);
        User findUser = userRepository.find(saveId);

        // then
        Assertions.assertThat(findUser.getUserId()).isEqualTo(user.getUserId());
        Assertions.assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
    }
}