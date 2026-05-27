package com.daehoon.fitlog.post.service;

import com.daehoon.fitlog.post.domain.Post;

import java.util.List;

public interface PostService {

    Post save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    Post findByTitle(String title);

    Post editTitle(Post existPost, String editTitle);

    Post editContent(Post existPost, String editContent);

    void delete(Post post);

    void clearStore();
}
