package me.iksad.optimizer.service;

import me.iksad.optimizer.dto.ReviewAvgResponse;

public interface ReviewService {
    ReviewAvgResponse readItemAvgRating(Long itemId);
}
