package me.iksad.optimizer.repository;

import me.iksad.optimizer.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, WithWishRepository {

    @EntityGraph(attributePaths = {"wishList.item"})
    @Query("select m from Member m where m.id = :memberId")
    Optional<Member> findByIdWithGraph(Long memberId);
}
