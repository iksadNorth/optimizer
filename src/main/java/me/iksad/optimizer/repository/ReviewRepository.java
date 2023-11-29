package me.iksad.optimizer.repository;

import me.iksad.optimizer.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long>, RatingRepository {
}
