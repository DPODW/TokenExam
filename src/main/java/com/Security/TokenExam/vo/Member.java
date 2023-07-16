package com.Security.TokenExam.vo;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
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

    public static Member insert(Member member, PasswordEncoder passwordEncoder){
        return Member.builder()
                .id(member.getId())
                .pwd(passwordEncoder.encode(member.getPwd()))
                .role(member.getRole())
                .build();
    }
}
