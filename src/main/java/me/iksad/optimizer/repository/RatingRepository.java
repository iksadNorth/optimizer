package me.iksad.optimizer.repository;

public interface RatingRepository {
    Double findAvgRatingByItemId(Long itemId);
}
