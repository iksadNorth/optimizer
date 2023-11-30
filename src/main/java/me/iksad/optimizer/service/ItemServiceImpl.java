package me.iksad.optimizer.service;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ItemRequest;
import me.iksad.optimizer.dto.ItemResponse;
import me.iksad.optimizer.entity.Item;
import me.iksad.optimizer.repository.ItemRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public ItemResponse readById(Long itemsId) {
        return itemRepository.findById(itemsId)
                .map(ItemResponse::fromEntity)
                .orElseThrow();
    }

    @Cacheable(value = "ItemResponse", key = "#itemsId")
    @Override
    public ItemResponse readByIdWithCaching(Long itemsId) {
        return itemRepository.findById(itemsId)
                .map(ItemResponse::fromEntity)
                .orElseThrow();
    }

    @Override
    public Page<ItemResponse> search(String name, Pageable pageable) {
        return itemRepository.findByName(name, pageable)
                .map(ItemResponse::fromEntity);
    }

    @Transactional
    @Override
    public ItemResponse create(ItemRequest request) {
        Item entity = request.toEntity();
        Item saved = itemRepository.save(entity);
        return ItemResponse.fromEntity(saved);
    }
}
