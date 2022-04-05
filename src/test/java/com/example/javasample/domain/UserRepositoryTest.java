package com.example.javasample.domain;

import com.example.javasample.SpringJUnitConfigIntegrationTest;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.IntStream;

import static com.example.javasample.domain.QMember.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired EntityManager em;

    JPAQueryFactory queryFactory;
    List<Member> members;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);
    }

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

    @Test
    @Transactional
    void queryDslTest() {
        User user = User.builder().username("name").password("password").build();
        em.persist(user);

        User findUser =
                queryFactory.selectFrom(QUser.user)
                .fetchOne();

        Assertions.assertThat(user).isEqualTo(findUser);
    }

}