package com.daehoon.fitlog.member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Member {

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private Grade grade;

}
