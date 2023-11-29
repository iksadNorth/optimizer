package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.MemberResponse;
import me.iksad.optimizer.dto.ItemResponse;
import me.iksad.optimizer.entity.Member;
import me.iksad.optimizer.entity.Wish;
import me.iksad.optimizer.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public MemberResponse readMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();

        List<ItemResponse> itemResponseList = member.getWishList().stream()
                .map(Wish::getItem)
                .map(ItemResponse::fromEntity)
                .toList();

        return new MemberResponse(
                member.getId(),
                member.getName(),
                itemResponseList
        );
    }
}
