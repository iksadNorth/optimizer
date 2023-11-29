package me.iksad.optimizer.service;

import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.dto.ReviewResponse;

import java.util.List;

public interface ReviewService {
    ReviewAvgResponse readItemAvgRating(Long itemId);

    List<ReviewResponse> readReviews();
}
