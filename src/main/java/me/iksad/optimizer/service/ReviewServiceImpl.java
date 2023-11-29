package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.dto.ReviewResponse;
import me.iksad.optimizer.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewAvgResponse readItemAvgRating(Long itemId) {
        return new ReviewAvgResponse(
                reviewRepository.findAvgRatingByItemId(itemId)
        );
    }

    @Override
    public List<ReviewResponse> readReviews() {
        return reviewRepository.findAll().stream()
                .map(ReviewResponse::fromEntity)
                .toList();
    }
}
