package inflearn.yh.course1;

import inflearn.yh.course1.discount.DiscountPolicy;
import inflearn.yh.course1.discount.FixDiscountPolicy;
import inflearn.yh.course1.member.MemberRepository;
import inflearn.yh.course1.member.MemberService;
import inflearn.yh.course1.member.MemberServiceImpl;
import inflearn.yh.course1.member.MemoryMemberRepository;
import inflearn.yh.course1.order.OrderService;
import inflearn.yh.course1.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
            memberRepository(),
            discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }


}
