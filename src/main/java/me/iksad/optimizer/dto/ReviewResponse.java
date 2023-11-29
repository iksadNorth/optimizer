package me.iksad.optimizer.dto;

import me.iksad.optimizer.entity.Review;

public record ReviewResponse(
        Long id,
        Double rating
) {
    public static ReviewResponse fromEntity(Review entity) {
        return new ReviewResponse(
                entity.getId(),
                entity.getRating()
        );
    }
}
