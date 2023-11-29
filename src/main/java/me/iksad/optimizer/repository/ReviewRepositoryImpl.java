package me.iksad.optimizer.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static me.iksad.optimizer.entity.QReview.review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements RatingRepository {
    private final JPAQueryFactory factory;

    @Override
    public Double findAvgRatingByItemId(Long itemId) {
        return factory
                .select(review.rating.avg())
                .from(review)

                .where(review.item.id.eq(itemId))

                .fetchFirst();
    }
}
