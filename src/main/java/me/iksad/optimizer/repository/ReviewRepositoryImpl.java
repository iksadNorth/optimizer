package me.iksad.optimizer.repository;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ReviewResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<ReviewResponse> findAllAsJustRating() {
        ConstructorExpression<ReviewResponse> reviewProjection = Projections.constructor(
                ReviewResponse.class,
                review.id.as("id"),
                review.rating.as("rating")
        );

        return factory
                .select(reviewProjection)
                .from(review)

                .fetch();
    }
}
