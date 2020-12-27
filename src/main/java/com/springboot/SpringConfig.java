package com.springboot;


import com.springboot.aop.TimeTraceAop;
import com.springboot.repository.*;
import com.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

// 1 : JPA
// 2 : 스프링데이터 JPA

@Configuration
public class SpringConfig {

    //    private DataSource dataSource;

    // @Autowired
    //    public SpringConfig(DataSource dataSource) {
    //        this.dataSource = dataSource;
    //    }

//    private final MemberRepository memberRepository;

    // 1
     private EntityManager em;

    // 생성자가 하나인경우 생략가능
    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
    public SpringConfig(EntityManager em) {

        // 2
        // this.memberRepository = memberRepository;

        //1
         this.em = em;
    }

    @Bean
    public MemberService memberService() {

        // 1
        return new MemberService(memberRepository());

        // 2
        // return new MemberService(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();

        // 객체지향적 설계
        // 다형성 활용
        // 인터페이스를 두고, 구현체를 바꿀수있음
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);

        // 1
        return new JpaMemberRepository(em);
    }

}
