package inflearn.yh.course1.order;

import inflearn.yh.course1.annotation.MainDiscountPolicy;
import inflearn.yh.course1.discount.DiscountPolicy;
import inflearn.yh.course1.member.Member;
import inflearn.yh.course1.member.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Getter
    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
