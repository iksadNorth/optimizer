package me.iksad.optimizer.controller;

import lombok.RequiredArgsConstructor;
import me.iksad.optimizer.dto.ItemResponse;
import me.iksad.optimizer.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/api/items/{itemsId}")
    public ItemResponse readById(
            @PathVariable Long itemsId
    ) {
        return itemService.readById(itemsId);
    }

    @GetMapping("/api/items")
    public Page<ItemResponse> search(
            @RequestParam String name,
            @PageableDefault Pageable pageable
            ) {
        return itemService.search(name, pageable);
    }
}
