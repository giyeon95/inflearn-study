package inflearn.yh.course1.order;

import static org.junit.jupiter.api.Assertions.*;

import inflearn.yh.course1.member.Grade;
import inflearn.yh.course1.member.Member;
import inflearn.yh.course1.member.MemberService;
import inflearn.yh.course1.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}