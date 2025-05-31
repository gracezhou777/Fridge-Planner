package com.fridgy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fridgy.mapper.ItemMapper;
import com.fridgy.model.entity.Item;
import com.fridgy.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Override
    public List<Item> getAllByUserId(Long userId) {
        return itemMapper.selectList(new QueryWrapper<Item>().eq("user_id", userId));
    }

    @Override
    public void addItem(Item item) {
        itemMapper.insert(item);
    }
}
