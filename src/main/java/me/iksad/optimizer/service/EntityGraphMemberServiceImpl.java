package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.MemberResponse;
import me.iksad.optimizer.repository.MemberRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(1)
@Service
@RequiredArgsConstructor
public class EntityGraphMemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberResponse readMemberInfo(Long memberId) {
        return memberRepository.findByIdWithGraph(memberId)
                .map(MemberResponse::fromEntity)
                .orElseThrow();
    }
}
