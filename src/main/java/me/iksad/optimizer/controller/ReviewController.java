package me.iksad.optimizer.controller;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.dto.ReviewResponse;
import me.iksad.optimizer.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/api/items/{itemId}/reviews")
    public ReviewAvgResponse readItemAvgRating(
            @PathVariable Long itemId
    ) {
        return reviewService.readItemAvgRating(itemId);
    }

    @GetMapping("/api/reviews")
    public List<ReviewResponse> readReviews() {
        return reviewService.readReviews();
    }
}
