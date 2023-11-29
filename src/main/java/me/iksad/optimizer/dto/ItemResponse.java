package me.iksad.optimizer.dto;

import me.iksad.optimizer.entity.Item;

import java.util.List;

public record ItemResponse(
        Long id,
        String name,
        Integer price
) {
    public static ItemResponse fromEntity(Item entity) {
        return new ItemResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice()
        );
    }

    public Item toEntity() {
        Item entity = new Item();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setPrice(this.price);
        return entity;
    }
}
