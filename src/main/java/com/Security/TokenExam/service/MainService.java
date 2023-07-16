package com.Security.TokenExam.service;

import com.Security.TokenExam.mapper.MemberMapper;
import com.Security.TokenExam.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MainService {
    private final MemberMapper memberMapper;

    private final PasswordEncoder encoder;

    public void signUp(Member member){
        memberMapper.save(Member.insert(member,encoder));
    }

    public Member signIn(Member member){
        Member id = memberMapper.findId(member.getId())
                 .filter(user -> encoder.matches(member.getPwd(), user.getPwd()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호 오류"));
        return id;
    }
}
