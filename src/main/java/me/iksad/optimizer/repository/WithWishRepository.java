package me.iksad.optimizer.repository;

import me.iksad.optimizer.entity.Member;

import java.util.Optional;

public interface WithWishRepository {
    Optional<Member> findMemberInfoById(Long memberId);
}
