package me.iksad.optimizer.repository;

import me.iksad.optimizer.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Page<Item> findByName(String name, Pageable pageable);
}
