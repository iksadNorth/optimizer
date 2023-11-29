package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ReviewAvgResponse;
import me.iksad.optimizer.entity.Item;
import me.iksad.optimizer.repository.ItemRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class EnhancedReviewServiceImpl implements ReviewService {
    private final ItemRepository itemRepository;

    @Override
    public ReviewAvgResponse readItemAvgRating(Long itemId) {
        return new ReviewAvgResponse(
                itemRepository.findById(itemId)
                        .map(Item::getAvgRating)
                        .orElse(0d)
        );
    }
}
