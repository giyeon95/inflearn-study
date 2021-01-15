package inflearn.yh.course1.order;

import inflearn.yh.course1.discount.DiscountPolicy;
import inflearn.yh.course1.discount.FixDiscountPolicy;
import inflearn.yh.course1.member.Member;
import inflearn.yh.course1.member.MemberRepository;
import inflearn.yh.course1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
