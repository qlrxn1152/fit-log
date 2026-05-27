package com.daehoon.fitlog.post.repository.impl;

import com.daehoon.fitlog.post.domain.Post;
import com.daehoon.fitlog.post.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
        assertThat(savedPost).isSameAs(post);
    }

    @Test
    void findById() {
        // given
        Post post = new Post("title1", "content1");
        postRepository.save(post);

        // when
        Post findPost = postRepository.findById(post.getId());

        // then
        assertThat(findPost).isNotNull();
        assertThat(findPost).isSameAs(post);
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
        assertThat(posts).isNotNull();
        assertThat(posts).hasSize(2);
        assertThat(posts).contains(post1, post2);
    }

    @Test
    void findByTitle() {
        // given
        Post post1 = new Post("title1", "content1");
        postRepository.save(post1);

        // when
        Post findPost = postRepository.findByTitle("title1");

        // then
        assertThat(findPost).isNotNull();
        assertThat(findPost).isSameAs(post1);
    }

    @Test
    void editContent() {
        // given
        Post post = new Post("title1", "content1");
        postRepository.save(post);

        // when
        postRepository.editContent(post, "content2");

        // then
        assertThat(post.getContent()).isEqualTo("content2");
    }

    @Test
    void editTitle() {
        // given
        Post post = new Post("title1", "content1");
        postRepository.save(post);

        // when
        postRepository.editTitle(post, "title2");

        // then
        assertThat(post.getTitle()).isEqualTo("title2");
    }

    @Test
    void delete() {
        // given
        Post post = new Post("title1", "content1");
        postRepository.save(post);

        // when
        postRepository.delete(post);
        List<Post> posts = postRepository.findAll();

        // then
        assertThat(posts.size()).isEqualTo(0);
        assertThat(posts.isEmpty()).isTrue();
    }

}