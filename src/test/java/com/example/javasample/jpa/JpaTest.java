package com.example.javasample.jpa;

import com.example.javasample.domain.*;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.javasample.domain.QMember.member;

@SpringBootTest
class JpaTest {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void flushTest() {
        // given
        User user1 = new User();
        user1.setUsername("user1");
        User user2 = new User();
        user2.setUsername("user1");

        // when
        em.persist(user1);
        em.persist(user2);

        TypedQuery<User> query = em.createQuery("select m from User m", User.class);
        List<User> members= query.getResultList();

        // then
    }

    @Test
    @Transactional
    void lazyLoadTest() {
        // given
        Team team = Team.builder().name("TeamA").build();
        Team team2 = Team.builder().name("TeamB").build();
        Member member = Member.builder().username("userName1").team(team).build();
        Member member2 = Member.builder().username("userName2").team(team2).build();

        // when
        em.persist(team);
        em.persist(team2);
        em.persist(member);
        em.persist(member2);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();
        System.out.println("members = " + members);
        members.forEach(member1 -> {
            System.out.println(member1.getTeam().getName());
        });
        

        // then
    }
}