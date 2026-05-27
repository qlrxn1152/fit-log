package com.daehoon.fitlog.post.repository.impl;

import com.daehoon.fitlog.post.domain.Post;
import com.daehoon.fitlog.post.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class PostRepositoryImpl implements PostRepository {

    private final Map<Long, Post> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Post save(Post post) {
        log.info("[SAVING POST] => [{}]", post);

        post.setId(++sequence);
        store.put(post.getId(), post);

        return post;
    }

    @Override
    public Post findById(Long id) {
        log.info("[FIND POST] => [{}]", id);
        return store.get(id);
    }

    @Override
    public List<Post> findAll() {
        log.info("[FIND ALL] => [{}]", store);
        return new ArrayList<>(store.values());
    }

}
