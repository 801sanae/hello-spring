package com.kmy.hellospring;

import com.kmy.hellospring.repository.MemberRepository;
import com.kmy.hellospring.repository.MemoryMemberRepository;
import com.kmy.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
