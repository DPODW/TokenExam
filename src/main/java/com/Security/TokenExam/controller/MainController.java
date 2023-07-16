package com.Security.TokenExam.controller;


import com.Security.TokenExam.mapper.MemberMapper;
import com.Security.TokenExam.sconfig.TokenProvider;
import com.Security.TokenExam.service.MainService;
import com.Security.TokenExam.vo.LoginResponse;
import com.Security.TokenExam.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
public class MainController {

    private final TokenProvider tokenProvider;

    private final MainService mainService;

    @PostMapping("/join")
    public ResponseEntity<Member> memberJoin(@RequestBody Member member){
        mainService.signUp(member);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/login")
    public LoginResponse memberLogin(@RequestBody Member member){
        Member loginMember = mainService.signIn(member);
        String token = tokenProvider.createToken(String.format("%s:%s", member.getId(), member.getRole()));
        return new LoginResponse(token,loginMember);
    }
}
