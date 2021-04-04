package inflearn.yh.course1.xml;

import static org.assertj.core.api.Assertions.assertThat;

import inflearn.yh.course1.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContextTest {

    @Test
    void xmlAPPContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);


    }

}
