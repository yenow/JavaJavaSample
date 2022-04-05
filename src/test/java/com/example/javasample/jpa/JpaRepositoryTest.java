package com.example.javasample.jpa;

import com.example.javasample.config.TestConfig;
import com.example.javasample.domain.User;
import com.example.javasample.domain.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;

@DataJpaTest
@Import(TestConfig.class)
public class JpaRepositoryTest {

    @Autowired EntityManager em;

    @Test
    void testUser() {
        // given
        User user = new User();
        user.setUsername("userA");

        // when
        em.persist(user);
        User findUser = em.find(User.class, user.getUserId());

        // then
        Assertions.assertThat(findUser.getUserId()).isEqualTo(user.getUserId());
        Assertions.assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
    }

}
