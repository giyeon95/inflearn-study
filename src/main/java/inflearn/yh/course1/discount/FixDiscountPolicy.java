package inflearn.yh.course1.discount;

import inflearn.yh.course1.member.Grade;
import inflearn.yh.course1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
