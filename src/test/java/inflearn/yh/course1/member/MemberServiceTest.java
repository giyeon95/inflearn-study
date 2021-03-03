package inflearn.yh.course1.member;

import inflearn.yh.course1.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    void beforeEach() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
            AppConfig.class);

        this.memberService = context.getBean("memberService", MemberService.class);
    }


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