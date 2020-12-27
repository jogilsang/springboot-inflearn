package com.springboot.repository;

import com.springboot.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        // persist : 영구히 저장한다.
        em.persist(member);
        return member;
    }

    // ID는 PK조회가능
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // JPQL
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체를 대상으로 쿼리를 날림
        // Entity(객체) 자체를 쿼리함
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Override
    public void cleanStore() {

    }
}
