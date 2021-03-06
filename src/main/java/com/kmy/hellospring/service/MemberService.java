package com.kmy.hellospring.service;

import com.kmy.hellospring.domain.Member;
import com.kmy.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public long join(Member member){
//        long start = System.currentTimeMillis();
//        try {
            //중복회원 검증
            validateDuplicateMember(member);
            memberRepository.save(member); // ctrl + t -> Extract Method (option + cmd + m)
            return member.getId();
//        }finally {
//            long finish = System.currentTimeMillis();
//            long timeRes = finish - start;
//            System.out.println("join finish : " + timeRes);
//        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
