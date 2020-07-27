package com.kmy.hellospring.service;

import com.kmy.hellospring.domain.Member;
import com.kmy.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void BeforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }


    @Test
    void 회원가입 () {
        //given
        Member member = new Member();
        member.setName("kmy");
        //when
        long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
    }

    @Test
    public void 중복회원_예외(){
        Member member1 = new Member();
        member1.setName("kmy");

        Member member2 = new Member();
        member2.setName("kmy");

        memberService.join(member1);

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}