package com.Security.TokenExam.service;

import com.Security.TokenExam.mapper.MemberMapper;
import com.Security.TokenExam.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MainService {
    private final MemberMapper memberMapper;

    public Optional<Member> signIn(Member member){
        Optional<Member> id = Optional.ofNullable(memberMapper.findId(member.getId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 없음")));
        return id;
    }
}
