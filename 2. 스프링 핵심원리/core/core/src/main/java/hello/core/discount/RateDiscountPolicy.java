package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * @author : user
 * @version : 1.0.0
 * @package : hello.core.discount
 * @name : RateDiscountPolicy.java
 * @date : 2021-01-11 오전 3:00
 * @modifyed :
 **/

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }

    }
}
