package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
* @package : hello.core.order
* @name : OrderServiceImpl.java
* @date : 2021-01-03 오후 9:21
* @author : user
* @version : 1.0.0
* @modifyed :
**/

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 할인 정책을 변경하려는 OrderServiceImpl 코드를 수정해야함
    // DIP 위반, 추상인터페이스와 구체적인 클레스에 의존
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // NullPointerException 발생
    // 해결 ? 구체적인 객체를 생성해서 주입해줘야함
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
