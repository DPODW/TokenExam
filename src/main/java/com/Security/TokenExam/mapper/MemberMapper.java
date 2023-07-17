package com.Security.TokenExam.mapper;

import com.Security.TokenExam.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface MemberMapper {
        void save(Member member);

        Optional<Member> findId(String id);
}
