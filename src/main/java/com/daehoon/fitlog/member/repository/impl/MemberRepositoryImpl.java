package com.daehoon.fitlog.member.repository.impl;

import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class MemberRepositoryImpl implements MemberRepository {

    private final Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public Member findByUsername(String username) {
        return store.values().stream()
                .filter(member -> username.equals(member.getUsername()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
