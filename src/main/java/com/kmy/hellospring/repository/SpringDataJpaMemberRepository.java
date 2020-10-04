package com.kmy.hellospring.repository;

import com.kmy.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    //select m from Member m where m.name = ? .. 인터페이스 이름만으로 쿼리등등 생성 가능.
    @Override
    Optional<Member> findByName(String name);
}
