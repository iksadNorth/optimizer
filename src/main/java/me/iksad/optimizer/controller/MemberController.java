package me.iksad.optimizer.controller;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.MemberResponse;
import me.iksad.optimizer.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/api/members/{memberId}/wishes")
    public MemberResponse readWishList(
            @PathVariable Long memberId
            ) {
        return memberService.readMemberInfo(memberId);
    }
}
