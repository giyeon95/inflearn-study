package inflearn.yh.course1.discount;

import inflearn.yh.course1.annotation.MainDiscountPolicy;
import inflearn.yh.course1.member.Grade;
import inflearn.yh.course1.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
