package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.MemberResponse;
import me.iksad.optimizer.repository.MemberRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class FetchJoinMemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberResponse readMemberInfo(Long memberId) {
        return memberRepository.findMemberInfoById(memberId)
                .map(MemberResponse::fromEntity)
                .orElseThrow();
    }
}
