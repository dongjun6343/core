package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 기획자가 할인정책을 변경했다.
 * 역할과 구현을 잘 나눴기 때문에 RateDiscountPolicy를 추가만 해주면 된다.
 */
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
