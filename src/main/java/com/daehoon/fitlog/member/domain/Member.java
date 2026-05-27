package com.daehoon.fitlog.member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@EqualsAndHashCode
@Slf4j
public class Member {

    private Long id;
    private String loginId;
    private String password;
    private Grade grade;

}
