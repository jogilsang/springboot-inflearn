package com.springboot;


import com.springboot.repository.JdbcMemberRepository;
import com.springboot.repository.JdbcTemplateMemberRepository;
import com.springboot.repository.MemberRepository;
import com.springboot.repository.MemoryMemberRepository;
import com.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();

        // 객체지향적 설계
        // 다형성 활용
        // 인터페이스를 두고, 구현체를 바꿀수있음
//       return new JdbcMemberRepository(dataSource);
       return new JdbcTemplateMemberRepository(dataSource);
    }

}
