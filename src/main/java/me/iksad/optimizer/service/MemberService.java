package me.iksad.optimizer.service;

import me.iksad.optimizer.dto.MemberResponse;

public interface MemberService {
    MemberResponse readMemberInfo(Long memberId);
}
