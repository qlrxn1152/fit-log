package com.daehoon.fitlog.member.repository.impl;

import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryImplTest {

    private final MemberRepository memberRepository = new MemberRepositoryImpl();

    @BeforeEach
    void setUp() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("test", "1q2w3e"); // null, test, 1q2w3e, USER

        // when
        Member savedMember = memberRepository.save(member);
        System.out.println("savedMember = " + savedMember.getId());

        // then
        Assertions.assertThat(savedMember).isEqualTo(member);
        Assertions.assertThat(savedMember.getId()).isEqualTo(1L);
    }

    @Test
    void findById() {
        // given
        Member member = new Member("test", "1q2w3e");
        memberRepository.save(member);

        // when
        Member findMember = memberRepository.findById(member.getId());

        // then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("test1", "1234");
        Member member2 = new Member("test2", "1234");
        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        Assertions.assertThat(members).hasSize(2);
        Assertions.assertThat(members).extracting("id").containsExactlyInAnyOrder(1L, 2L);
        Assertions.assertThat(members).contains(member1, member2);
    }
}