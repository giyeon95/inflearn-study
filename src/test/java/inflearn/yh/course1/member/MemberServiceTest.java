package inflearn.yh.course1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    private final MemberService memberService = new MemberServiceImpl();

    @Test
    void joinTest() {
        //given
        Member member = new Member(1L, "kiyeon", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertEquals(member, findMember);
    }

}