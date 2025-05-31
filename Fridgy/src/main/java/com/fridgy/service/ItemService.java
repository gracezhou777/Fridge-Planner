package com.fridgy.service;

import com.fridgy.model.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllByUserId(Long userId);
    void addItem(Item item);
}
