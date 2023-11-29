package me.iksad.optimizer.repository;

import me.iksad.optimizer.dto.ReviewResponse;

import java.util.List;

public interface RatingRepository {
    Double findAvgRatingByItemId(Long itemId);

    List<ReviewResponse> findAllAsJustRating();
}
