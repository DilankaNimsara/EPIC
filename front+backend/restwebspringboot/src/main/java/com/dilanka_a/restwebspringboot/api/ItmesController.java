package com.dilanka_a.restwebspringboot.api;

import com.dilanka_a.restwebspringboot.dto.ItemsDto;
import com.dilanka_a.restwebspringboot.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@CrossOrigin
public class ItmesController {

    private final ItemsService itemsService;

    @Autowired
    public ItmesController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping
    void insertItems(@RequestBody ItemsDto itemsDto) {
        itemsService.insertItems(itemsDto);
    }

    @GetMapping
    List<ItemsDto> selectAllItems() {
        return itemsService.getAllItems();
    }

    @GetMapping("/{id}")
    ItemsDto selectItemByID(@PathVariable("id") int id) {
        return itemsService.getItemByid(id);
    }

    @PutMapping("/{id}")
    void updateItemBYID(@RequestBody ItemsDto itemsDto, @PathVariable("id") int id) {
        itemsService.updateItemByID(itemsDto, id);
    }

    @DeleteMapping("/{id}")
    void deleteItemBYID(@PathVariable("id") int id) {
        itemsService.deleteItemByID(id);
    }

}
