package me.iksad.optimizer.repository;

import me.iksad.optimizer.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish,Long> {
}
