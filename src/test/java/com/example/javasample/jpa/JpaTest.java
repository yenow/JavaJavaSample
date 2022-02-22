package com.example.javasample.jpa;

import com.example.javasample.domain.Address;
import com.example.javasample.domain.Member;
import com.example.javasample.domain.User;
import com.example.javasample.domain.UserRepository;
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

    @Transactional
    @Rollback(false)
    @Test
    void testValueCollection () {

        Member member = new Member();
        member.setUsername("member1");
        member.setHomeAddress(new Address("old","street","zipcode"));

        member.getFavoriteFoods().add("치킨");
        member.getFavoriteFoods().add("족발");
        member.getFavoriteFoods().add("피자");

//        member.getAddressHistory().add(new Address("old1","street1","zipcode"));
//        member.getAddressHistory().add(new Address("old2","street2","zipcode"));

        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());

        // 치킨 -> 한식
        findMember.getFavoriteFoods().remove("치킨");
        findMember.getFavoriteFoods().add("한식");

//        findMember.getAddressHistory().remove(new Address("old1","street1","zipcode"));
//        findMember.getAddressHistory().add(new Address("newCity1","street1","zipcode"));
    }

    @Transactional
    @Test
    void searchAndParam() {
        Member newMember = new Member();
        newMember.setUsername("newMember1");
        newMember.setHomeAddress(new Address("old","street","zipcode"));

        JPAQueryFactory query = new JPAQueryFactory(em);
//        Member findMember =
//                query.select(member)
//                .from(member)
//                .where(
//                    member.username.eq("member1"),
//                    member.age.eq(10)
//                ).fetchOne();

        QueryResults<Member> results = query.selectFrom(member)
                .fetchResults();

        results.getTotal();
        List<Member> content = results.getResults();
    }
}