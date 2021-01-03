package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
* @package : hello.core.discount
* @name : FixDiscountPolicy.java
* @date : 2021-01-03 오후 9:02
* @author : jogilsang
* @version : 1.0.0
* @modifyed :
**/

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
