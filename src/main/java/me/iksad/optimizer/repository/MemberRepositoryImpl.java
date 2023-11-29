package me.iksad.optimizer.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static me.iksad.optimizer.entity.QItem.item;
import static me.iksad.optimizer.entity.QMember.member;
import static me.iksad.optimizer.entity.QWish.wish;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements WithWishRepository {
    private final JPAQueryFactory factory;

    @Override
    public Optional<Member> findMemberInfoById(Long memberId) {
        Member entity = factory
                .select(member)
                .from(member)

                .where(member.id.eq(memberId))

                .join(member.wishList, wish).fetchJoin()
                .join(wish.item, item).fetchJoin()

                .fetchFirst();

        return Optional.ofNullable(entity);
    }
}
