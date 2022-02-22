package com.example.javasample.jpa;

import com.example.javasample.domain.Member;
import com.example.javasample.domain.QMember;
import com.example.javasample.domain.QTeam;
import com.example.javasample.domain.Team;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.example.javasample.domain.QMember.member;
import static com.example.javasample.domain.QTeam.team;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
@DisplayName("queryDsl 테스트")
public class QueryDslTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    List<Member> members = new ArrayList<>();
    List<Team> teams = new ArrayList<>();

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);

        IntStream.rangeClosed(1,3).forEach(value -> {
            Team team = Team.builder().name("team" + value).build();
            em.persist(team);
            teams.add(team);
        });

        IntStream.rangeClosed(0,10).forEach(value -> {

            Member member = Member.builder().username("username"+value).age(10).age(value)
                    .team(teams.get(value % teams.size()))
                    .build();
            members.add(member);
            em.persist(member);
        });

        em.persist(Member.builder().age(11).team(teams.get(0)).build());
        em.persist(Member.builder().username("team1").age(11).team(teams.get(0)).build());
        em.persist(Member.builder().username("team2").age(11).team(teams.get(0)).build());
        em.persist(Member.builder().username("team3").age(11).team(teams.get(0)).build());
    }

    @DisplayName("정렬 테스트")
    @Test
    void alignTest() {
        List<Member> findMembers = queryFactory
                .selectFrom(member)
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        findMembers.forEach(member -> System.out.println("member = " + member));
    }

    @DisplayName("페이징")
    void pasing() {
        /* 조회 건수 제한 */
        List<Member> result = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1) //0부터 시작(zero index)
                .limit(2) //최대 2건 조회
                .fetch();

        assertThat(result.size()).isEqualTo(2);
    }

    @DisplayName("페이징2")
    @Test
    public void paging2() {
        QueryResults<Member> queryResults = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetchResults();
        assertThat(queryResults.getTotal()).isEqualTo(12);
        assertThat(queryResults.getLimit()).isEqualTo(2);
        assertThat(queryResults.getOffset()).isEqualTo(1);
        assertThat(queryResults.getResults().size()).isEqualTo(2);
    }

    @DisplayName("집합함수")
    @Test
    void aggregation() {
        List<Tuple> tuples = queryFactory
                .select(
                        member.age.count()
                        , member.age.max()
                        , member.age.min()
                        , member.age.avg()
                        , member.age.sum()
                ).from(member)
                .fetch();

        System.out.println(tuples.get(0).get(member.age.count()));
        System.out.println(tuples.get(0).get(member.age.max()));
        System.out.println(tuples.get(0).get(member.age.min()));
        System.out.println(tuples.get(0).get(member.age.avg()));
        System.out.println(tuples.get(0).get(member.age.sum()));
    }

    @DisplayName("집합함수 groupby 사용")
    @Test
    void aggregation2() {
        List<Tuple> tuples = queryFactory
            .select(
                team.name
                ,member.age.count()
                , member.age.max()
                , member.age.min()
                , member.age.avg()
                , member.age.sum()
            ).from(member)
            .join(member.team, team)
            .groupBy(member.team.name)
            .fetch();

        Tuple team1 = tuples.get(0);
        Tuple team2 = tuples.get(1);
        Tuple team3 = tuples.get(2);

        System.out.println(team1.get(team.name));
        System.out.println(team1.get(member.age.count()));
        System.out.println(team1.get(member.age.max()));
        System.out.println(team2.get(team.name));
        System.out.println(team2.get(member.age.count()));
        System.out.println(team2.get(member.age.max()));
        System.out.println(team3.get(team.name));
        System.out.println(team3.get(member.age.count()));
        System.out.println(team3.get(member.age.max()));
    }

    @DisplayName("집합함수 having 사용")
    @Test
    void aggregation3() {
        List<Tuple> tuples = queryFactory
                .select(
                        team.name
                        ,member.age.count()
                        , member.age.max()
                        , member.age.min()
                        , member.age.avg()
                        , member.age.sum()
                ).from(member)
                .join(member.team, team)
                .groupBy(member.team.name)
                .having(member.age.lt(8))
                .fetch();

        Tuple team1 = tuples.get(0);
        Tuple team2 = tuples.get(1);
        Tuple team3 = tuples.get(2);

        System.out.println(team1.get(team.name));
        System.out.println(team1.get(member.age.count()));
        System.out.println(team1.get(member.age.max()));
        System.out.println(team2.get(team.name));
        System.out.println(team2.get(member.age.count()));
        System.out.println(team2.get(member.age.max()));
        System.out.println(team3.get(team.name));
        System.out.println(team3.get(member.age.count()));
        System.out.println(team3.get(member.age.max()));
    }

    /**
     * 팀 A에 소속된 모든 회원
     */
    @Test
    public void join() throws Exception {
        List<Member> result = queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .where(team.name.eq("team1"))
                .fetch();

        result.forEach(member1 -> System.out.println("member1 = " + member1));
//        assertThat(result)
//                .extracting("username")
//                .contains("member0", "member3");
    }

    @Test
    public void theta_join() throws Exception {

        List<Member> result = queryFactory
                .select(member)
                .from(member, team)
                .where(member.username.eq(team.name))
                .fetch();

        result.forEach(member1 -> System.out.println("member1 = " + member1));
    }

    @Test
    public void join_on_no_relation() throws Exception {
        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();
        for (Tuple tuple : result) {
            System.out.println("t=" + tuple);
        }
    }
}
