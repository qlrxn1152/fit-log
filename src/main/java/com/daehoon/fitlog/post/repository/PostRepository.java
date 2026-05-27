package com.daehoon.fitlog.post.repository;

import com.daehoon.fitlog.post.domain.Post;

import java.util.List;

public interface PostRepository {

    Post save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    List<Post> findByTitle(String title);

    Post editTitle(Post existPost, String editTitle);

    Post editContent(Post existPost, String editContent);

    void delete(Post post);

    void clearStore();
}
