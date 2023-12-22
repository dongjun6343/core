package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    @Autowired // ac.getBean(MemberRepository.class)과 같다라고 생각. 생성자에 걸면 자동으로 의존성 주입(의존관계 자동 주입)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
