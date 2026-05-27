package com.daehoon.fitlog.member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter @ToString @EqualsAndHashCode
public class Member {

    private Long id;
    private String username;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }
}
