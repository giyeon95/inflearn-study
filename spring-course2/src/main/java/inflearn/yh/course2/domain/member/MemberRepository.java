package inflearn.yh.course2.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 동시성 문제를 해결하기 위해서는 ConcurrentHashMap, AtomicLong
 */
@NoArgsConstructor
public class MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0L);

    @Getter
    private static final MemberRepository instance = new MemberRepository();

    public Member save(Member member) {

        member.setId(sequence.addAndGet(1L));
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }


}
