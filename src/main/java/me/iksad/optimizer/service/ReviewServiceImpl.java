package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.repository.ReviewRepository;
import org.springframework.stereotype.Service;

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
}
