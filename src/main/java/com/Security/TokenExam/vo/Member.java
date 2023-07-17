package com.Security.TokenExam.vo;

import lombok.Data;

@Data
public class Member {

    private String id;

    private String pwd;

    private String role;

    public Member(String id, String pwd, String role) {
        this.id = id;
        this.pwd = pwd;
        this.role = role;
    }
}
