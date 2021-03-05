package beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import inflearn.yh.course1.AppConfig;
import inflearn.yh.course1.member.MemberService;
import inflearn.yh.course1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        @Test
        @DisplayName("빈 이름으로 조회")
        void findBeanByName() {
                MemberService memberService = ac.getBean("memberService", MemberService.class);
                assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        }

        @Test
        @DisplayName("이름없이 타입으로 조회")
        void findBeanByType() {
                MemberService memberService = ac.getBean(MemberService.class);
                assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        }

        @Test
        @DisplayName("구체 타입으로 조회")
        void findBeanByName2() {
                MemberService memberService = ac.getBean("memberService", MemberService.class);
                assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        }

        @Test
        @DisplayName("빈 이름으로 조회x")
        void findBeanByNameX() {
                assertThrows(NoSuchBeanDefinitionException.class,
                    () -> ac.getBean("xxxxx", MemberService.class));



        }


}
