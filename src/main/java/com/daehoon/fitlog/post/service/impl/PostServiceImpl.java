package com.daehoon.fitlog.post.service.impl;

import com.daehoon.fitlog.post.domain.Post;
import com.daehoon.fitlog.post.repository.PostRepository;
import com.daehoon.fitlog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    // TODO : 여러 검증로직들 추가해줘야함
    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public Post editTitle(Post existPost, String editTitle) {
        return postRepository.editTitle(existPost, editTitle);
    }

    @Override
    public Post editContent(Post existPost, String editContent) {
        return postRepository.editContent(existPost, editContent);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void clearStore() {
        postRepository.clearStore();
    }
}
