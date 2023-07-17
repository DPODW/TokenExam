package com.Security.TokenExam.controller;


import com.Security.TokenExam.mapper.MemberMapper;
import com.Security.TokenExam.service.MainService;
import com.Security.TokenExam.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
public class MainController {

    private final MemberMapper memberMapper;

    private final MainService mainService;

    @PostMapping("/join")
    public ResponseEntity<Member> memberJoin(@RequestBody Member member){
        memberMapper.save(member);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/login")
    public Optional<Member> memberLogin(@RequestBody Member member){
        return mainService.signIn(member);
    }
}
