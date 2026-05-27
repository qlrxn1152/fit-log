package com.daehoon.fitlog.member.repository;

import com.daehoon.fitlog.member.domain.Member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long id);

    List<Member> findAll();

}
