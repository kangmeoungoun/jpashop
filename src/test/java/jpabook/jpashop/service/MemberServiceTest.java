package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest{

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    @DisplayName("회원가입")
    void memberJoin()  throws Exception{
        //given
        Member member = new Member();
        member.setName("kang");
        //when
        Long saveId = memberService.join(member);
        em.flush();
        //then
        assertThat(member).isEqualTo(memberService.findOne(saveId));

    }
    @Test
    @DisplayName("중복 회원 예외")
    void duplicateMember()  throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("kang");
        Member member2 = new Member();
        member2.setName("kang");
        //when
        memberService.join(member1);
        //then
        assertThrows(IllegalStateException.class,() -> memberService.join(member2)); //예외가 발새해야 한다.
    }
}