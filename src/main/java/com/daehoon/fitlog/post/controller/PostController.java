package com.daehoon.fitlog.post.controller;

import com.daehoon.fitlog.post.domain.Post;
import com.daehoon.fitlog.post.domain.PostForm;
import com.daehoon.fitlog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/add")
    public String addPostHtml(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "posts/addForm";
    }

    @PostMapping("/post/add")
    public String addPost(@ModelAttribute PostForm postForm) {
        Post post = new Post(postForm.getTitle(), postForm.getContent());
        log.info("[POST SAVING] POST => [{}]", post);

        postService.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String postsHtml(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "posts/posts";
    }


}
