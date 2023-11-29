package me.iksad.optimizer.controller;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
