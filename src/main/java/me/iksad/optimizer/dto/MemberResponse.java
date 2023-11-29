package me.iksad.optimizer.dto;

import lombok.Builder;
import me.iksad.optimizer.entity.Member;
import me.iksad.optimizer.entity.Wish;

import java.util.List;

@Builder(toBuilder = true)
public record MemberResponse(
        Long id,
        String name,
        List<ItemResponse> wishList
) {
    public MemberResponse(
            Long id,
            String name
    ) {
        this(id, name, null);
    }

    public static MemberResponse fromEntity(Member entity) {
        List<ItemResponse> itemResponseList = entity.getWishList().stream()
                .map(Wish::getItem)
                .map(ItemResponse::fromEntity)
                .toList();
        return new MemberResponse(
                entity.getId(),
                entity.getName(),
                itemResponseList
        );
    }
}
