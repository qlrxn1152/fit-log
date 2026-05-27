package com.daehoon.fitlog.post.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
public class PostForm {

    private String title;
    private String content;

    public PostForm() {
    }
}
