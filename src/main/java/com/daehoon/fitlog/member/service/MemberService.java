package com.daehoon.fitlog.member.service;

import com.daehoon.fitlog.member.domain.Member;

import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member findById(Long id);

    List<Member> findAll();

}
