package com.springboot.service;

import com.springboot.domain.Member;
import com.springboot.repository.MemberRepository;
import com.springboot.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// @Service
// JPA는 항상 트랜잭션이 있어야함. 조인들어올때, 트랜잭션 안에서 실행되어야함
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원가입
    * */
    public Long join (Member member) {

        Long start = System.currentTimeMillis();

        validateDuplicateMember(member); // 같은 이름이 있는 중복 회원x

        memberRepository.save(member);
        return member.getId();

// AOP 없이 수동으로 사용하기
//        try {
//
//            validateDuplicateMember(member); // 같은 이름이 있는 중복 회원x
//
//            memberRepository.save(member);
//            return member.getId();
//
//        }finally {
//            Long end = System.currentTimeMillis();
//            Long timeMs = start - end;
//            System.out.println("join method = "+ timeMs +"ms");
//
//        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원입니다.");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /*
    * 전체회원조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
