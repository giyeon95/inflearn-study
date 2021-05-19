package inflearn.yh.course1.discount;

import static org.assertj.core.api.Assertions.assertThat;

import inflearn.yh.course1.member.Grade;
import inflearn.yh.course1.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();



    @Test
    @DisplayName("VIP는 10% 할인 테스트")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discountPrice = discountPolicy.discount(member, 10000);
        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌경우 할인이 안된다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        //when
        int discountPrice = discountPolicy.discount(member, 10000);
        //then
        assertThat(discountPrice).isEqualTo(0);
    }

}