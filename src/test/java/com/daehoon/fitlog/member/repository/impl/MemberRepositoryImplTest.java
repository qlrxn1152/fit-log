package com.daehoon.fitlog.member.repository.impl;

import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.member.repository.MemberRepository;
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
        Member member = new Member("userA", "1234");

        // when
        memberRepository.save(member);
        Member savedMember = memberRepository.findById(1L);

        // then
        Assertions.assertThat(savedMember).isSameAs(member);
        Assertions.assertThat(member.getId()).isEqualTo(1L);
    }

    @Test
    void findById() {
        // given
        Member member = new Member("userA", "1234");

        // when
        memberRepository.save(member);
        Member savedMember = memberRepository.findById(1L);

        // then
        Assertions.assertThat(savedMember).isSameAs(member);
        Assertions.assertThat(member.getId()).isEqualTo(1L);
    }

    @Test
    void findByUsername() {
        // given
        Member member = new Member("userA", "1234");
        memberRepository.save(member);

        // when
        Member findMember = memberRepository.findByUsername("userA");

        // then
        Assertions.assertThat(findMember).isSameAs(member);

    }

    @Test
    void findAll() {
        // given
        Member memberA = new Member("userA", "1234");
        Member memberB = new Member("userB", "1234");
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        Assertions.assertThat(members).isNotEmpty();
        Assertions.assertThat(members.size()).isEqualTo(2);
        Assertions.assertThat(members).contains(memberA, memberB);

    }

}