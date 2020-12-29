package com.dilanka_a.restwebspringboot.service;

import com.dilanka_a.restwebspringboot.dto.ItemsDto;

import java.util.List;

public interface ItemsService {

    void insertItems(ItemsDto itemsDto);

    ItemsDto getItemByid(int id);

    List<ItemsDto> getAllItems();

    void deleteItemByID(int id);

    void updateItemByID(ItemsDto itemsDto, int id);
}
