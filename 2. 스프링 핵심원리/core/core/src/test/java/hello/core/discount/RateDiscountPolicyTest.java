package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 성공테스트
    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertEquals(discount, 1000);
    }
    @Test
    @DisplayName("VIP가 아니면 10%할인이 적용안되어야 한다.")
    // 실패테스트트
    void vip_x(){
        //given
        Member member = new Member(2L, "memberNomal", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertEquals(discount, 0);
    }

}