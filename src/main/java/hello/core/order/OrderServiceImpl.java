package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); DIP 위반.

    //   DIP를 지킴 -> NPE발생.. -> 어떻게 해결해야할까?
    private final DiscountPolicy discountPolicy;

    /**
     * 생성자 주입
     * 생성자가 1개이면 @Autowired 생략가능
     * 특징 : 불변. 고정
     *
     * new OrderServiceImpl(memberRepository, discountPolicy)
     * - 자바 문법임.
     *
     * 롬복 적용
     * @RequiredArgsConstructor : final이 붙은 필드를 모아서 생성자를 자동으로 만들어줌.
     */
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
