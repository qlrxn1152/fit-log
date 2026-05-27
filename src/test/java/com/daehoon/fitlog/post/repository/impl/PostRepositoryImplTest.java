package com.daehoon.fitlog.post.repository.impl;

import com.daehoon.fitlog.post.domain.Post;
import com.daehoon.fitlog.post.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    private PostRepository postRepository;


    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
        postRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Post post = new Post("title1", "content1");

        // when
        Post savedPost = postRepository.save(post);

        // then
        Assertions.assertThat(savedPost).isSameAs(post);

    }

    @Test
    void findById() {
        // given
        Post post = new Post("title1", "content1");
        postRepository.save(post);

        // when
        Post findPost = postRepository.findById(post.getId());

        // then
        Assertions.assertThat(findPost).isNotNull();
        Assertions.assertThat(findPost).isSameAs(post);
    }

    @Test
    void findAll() {
        // given
        Post post1 = new Post("title1", "content1");
        Post post2 = new Post("title2", "content2");
        postRepository.save(post1);
        postRepository.save(post2);

        // when
        List<Post> posts = postRepository.findAll();

        // then
        Assertions.assertThat(posts).isNotNull();
        Assertions.assertThat(posts).hasSize(2);
        Assertions.assertThat(posts).contains(post1, post2);
    }
}