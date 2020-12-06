package com.springboot;


import com.springboot.repository.MemberRepository;
import com.springboot.repository.MemoryMemberRepository;
import com.springboot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
