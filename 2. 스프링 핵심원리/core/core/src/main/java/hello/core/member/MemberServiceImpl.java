package hello.core.member;

// DIP를 위반한다
// 추상화(MemberRepository)에도 의존하고, 구체화(MemoryMemberRepository)에도 의존한다
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
