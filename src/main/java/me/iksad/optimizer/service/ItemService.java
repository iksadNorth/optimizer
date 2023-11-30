package me.iksad.optimizer.service;

import me.iksad.optimizer.dto.ItemRequest;
import me.iksad.optimizer.dto.ItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {
    ItemResponse readById(Long itemsId);

    ItemResponse readByIdWithCaching(Long itemsId);

    Page<ItemResponse> search(String name, Pageable pageable);

    ItemResponse create(ItemRequest request);
}
