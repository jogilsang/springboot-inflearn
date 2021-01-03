package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 데이터베이스가 정해지지않았으므로, 테스트용도로 생성
// 컨커런트 해쉬맵을 써야 동시성 이슈를 제거가능
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
