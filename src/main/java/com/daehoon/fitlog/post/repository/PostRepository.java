package com.daehoon.fitlog.post.repository;

import com.daehoon.fitlog.post.domain.Post;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    void clearStore();
}
