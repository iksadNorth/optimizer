package me.iksad.optimizer.dto;

import me.iksad.optimizer.entity.Item;

public record ItemRequest(
        String name,
        Integer price
) {
    public Item toEntity() {
        Item entity = new Item();
        entity.setName(this.name);
        entity.setPrice(this.price);
        return entity;
    }
}
