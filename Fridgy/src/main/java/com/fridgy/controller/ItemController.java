package com.fridgy.controller;

import com.fridgy.model.entity.Item;
import com.fridgy.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
@Tag(name = "Item接口", description = "冰箱物品管理")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    @Operation(summary = "获取当前用户所有物品")
    public List<Item> list(@RequestParam Long userId) {
        return itemService.getAllByUserId(userId);
    }

    @PostMapping
    @Operation(summary = "添加物品")
    public void add(@RequestBody Item item) {
        itemService.addItem(item);
    }
}
