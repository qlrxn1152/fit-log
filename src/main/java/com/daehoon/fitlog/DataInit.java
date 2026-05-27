package com.daehoon.fitlog;

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

    @PostConstruct
    public void init() {
        Post post1 = new Post("title1", "content1");
        Post post2 = new Post("title2", "content2");

        postService.save(post1);
        postService.save(post2);

        log.info("[INIT DATA]");
    }


}
