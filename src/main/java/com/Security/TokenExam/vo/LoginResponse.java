package com.Security.TokenExam.vo;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private Member member;

    public LoginResponse() {
    }


    public LoginResponse(String token, Member member) {
        this.token = token;
        this.member = member;
    }

}
