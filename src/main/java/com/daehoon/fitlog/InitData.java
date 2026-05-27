package com.daehoon.fitlog;

import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.member.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class InitData {

    private final MemberService memberService;

    @PostConstruct
    public void init() {
        Member member = new Member("test", "test!");
        memberService.save(member);

        log.info("[INITDATA] [MEMBER SAVE] member={}", member);
    }

}
