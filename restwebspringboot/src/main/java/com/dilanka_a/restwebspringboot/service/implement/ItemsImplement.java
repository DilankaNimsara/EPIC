package com.dilanka_a.restwebspringboot.service.implement;

import com.dilanka_a.restwebspringboot.dto.ItemsDto;
import com.dilanka_a.restwebspringboot.entity.Items;
import com.dilanka_a.restwebspringboot.repo.ItemsRepo;
import com.dilanka_a.restwebspringboot.service.ItemsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsImplement implements ItemsService {

    private final ModelMapper modelMapper;
    private final ItemsRepo itemsRepo;

    @Autowired
    public ItemsImplement(ModelMapper modelMapper, ItemsRepo itemsRepo) {
        this.modelMapper = modelMapper;
        this.itemsRepo = itemsRepo;
    }

    @Override
    public void insertItems(ItemsDto itemsDto) {
        itemsRepo.save(modelMapper.map(itemsDto, Items.class));
    }

    @Override
    public ItemsDto getItemByid(int id) {
        Items items = itemsRepo.findById(id).orElse(null);
        return modelMapper.map(items, new TypeToken<ItemsDto>() {
        }.getType());
    }

    @Override
    public List<ItemsDto> getAllItems() {
        List<Items> items = itemsRepo.findAll();
        return modelMapper.map(items, new TypeToken<List<ItemsDto>>() {
        }.getType());
    }

    @Override
    public void deleteItemByID(int id) {
        itemsRepo.deleteById(id);
    }

    @Override
    public void updateItemByID(ItemsDto itemsDto, int id) {
        ItemsDto itemToUpdate = getItemByid(id);
        if (itemToUpdate.getIid() == id) {
            itemsRepo.save(modelMapper.map(itemsDto, Items.class));
        }
    }
}
