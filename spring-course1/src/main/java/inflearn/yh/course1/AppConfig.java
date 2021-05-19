package inflearn.yh.course1;

import inflearn.yh.course1.discount.DiscountPolicy;
import inflearn.yh.course1.discount.RateDiscountPolicy;
import inflearn.yh.course1.member.MemberRepository;
import inflearn.yh.course1.member.MemberService;
import inflearn.yh.course1.member.MemberServiceImpl;
import inflearn.yh.course1.member.MemoryMemberRepository;
import inflearn.yh.course1.order.OrderService;
import inflearn.yh.course1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
            memberRepository(),
            discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
