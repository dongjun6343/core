package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        //참조값이 같을까? 다를까?
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);


        MemberRepository memberRepository = orderService.getMemberRepository();
        System.out.println("memberRepository3 = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    /**
     * 3번의 new가 호출되는데 왜 같은 인스턴스가 조회가 될까?
     * memberService -> memberRepository1 = hello.core.member.MemoryMemberRepository@26f1249d
     * orderService -> memberRepository2 = hello.core.member.MemoryMemberRepository@26f1249d
     * memberRepository3 = hello.core.member.MemoryMemberRepository@26f1249d
     */


}
