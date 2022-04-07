package com.example.repository;

import com.example.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    void test() {
        // given
        Member member = Member.builder().age(10).username("name").build();

        // when
        Long id = memberRepository.save(member);

        // then
        System.out.println(id);
        System.out.println(member);
    }
}