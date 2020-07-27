package com.kmy.hellospring;

import com.kmy.hellospring.domain.Member;
import com.kmy.hellospring.repository.MemoryMemberRepository;
import com.kmy.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemberService memberService;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("kmy");

        repository.save(member);

        Member res = repository.findById(member.getId()).get();

        System.out.print("res = " + (res ==member));

//        Assertions.assertEquals(res,null);

        assertThat(member).isEqualTo(res);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("kmy1");
        repository.save((member1));

        Member member2 = new Member();
        member2.setName("kmy2");
        repository.save((member2));

        Member result = repository.findByName("kmy1").get();

        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll_test(){
        Member member1 = new Member();
        member1.setName("kmy1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kmy2");
        repository.save(member2);

        List<Member> res = repository.findAll();

        assertThat(res.size()).isEqualTo(2);
    }

}
