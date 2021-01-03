package com.springboot.repository;

import com.springboot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
//        Long>, MemberRepository {
public interface SpringDataJpaMemberRepository extends MemberRepository{

    @Override
    Optional<Member> findByName(String name);

}
