package com.springboot.repository;

import com.springboot.domain.Member;
import org.junit.After;
import org.junit.Test;

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @After
    public void afterEach(){
        repository.cleanStore();
    }


    @Test
    public void save() {

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

    }

    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        System.out.println(member1.getName() == result.getName() ? "yes" : "No");
    }




}
