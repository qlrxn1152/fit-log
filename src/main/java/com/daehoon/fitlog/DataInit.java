package com.daehoon.fitlog;

import com.daehoon.fitlog.member.domain.Member;
import com.daehoon.fitlog.member.service.MemberService;
import com.daehoon.fitlog.post.domain.Post;
import com.daehoon.fitlog.post.service.PostService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInit {

    private final PostService postService;
    private final MemberService memberService;

    @PostConstruct
    public void init() {
        Post post1 = new Post("title1", "content1");
        Post post2 = new Post("title2", "content2");
        postService.save(post1);
        postService.save(post2);

        Member member1 = new Member("userA", "1234");
        Member member2 = new Member("test", "1234");
        memberService.save(member1);
        memberService.save(member2);

        log.info("[INIT DATA]");
    }


}
