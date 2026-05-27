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

    // TODO : 동시성 문제 가능성있음 => AtomicLong, ConcurrentHashMap 으로 변경
    private Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;


    @Override
    public Member save(Member member) { // null, test, 1q2w3e, USER
        log.info("[MemberRepositoryImpl] [SAVE] member: {}", member);

        member.setId(++sequence); // 1l, test, 1q2w3e, USER

        store.put(member.getId(), member); // < 1l, (1l,test,1q2w3e,USER) >

        return member;
    }

    @Override
    public Member findById(Long id) {
        log.info("[MemberRepositoryImpl] [FindById] memberId: {}", id);
        return store.get(id);
    }

    @Override
    public List<Member> findAll() {
        log.info("[MemberRepositoryImpl] [FindAll]");

        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }

}
