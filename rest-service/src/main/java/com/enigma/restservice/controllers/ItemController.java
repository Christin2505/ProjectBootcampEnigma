package com.enigma.restservice.controllers;

import com.enigma.restservice.entities.Item;
import com.enigma.restservice.models.ItemModel;
import com.enigma.restservice.models.ResponseMessage;
import com.enigma.restservice.services.ItemService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseMessage<ItemModel> add(@RequestBody ItemModel model) {
        Item entity = itemService.add(new Item(model.getName()));
        ModelMapper modelMapper = new ModelMapper();
        ItemModel data = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ItemModel> edit(@PathVariable Integer id, @RequestBody ItemModel model) {
        ModelMapper modelMapper = new ModelMapper();
        model.setId(id);

        Item entity = modelMapper.map(model, Item.class);
        entity = itemService.edit(entity);
        if (entity != null) {
            ItemModel data = modelMapper.map(entity, ItemModel.class);
            return ResponseMessage.success(data);
        } else {
            return ResponseMessage.error(1, "Data Not Found .");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ItemModel> remove(@PathVariable Integer id) {
        Item entity = itemService.removeById(id);
        if (entity != null) {
            ModelMapper modelMapper = new ModelMapper();
            ItemModel model = modelMapper.map(entity, ItemModel.class);
            return ResponseMessage.success(model);
        } else {
            return ResponseMessage.error(1, "Data Not Found .");
        }
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemModel> findById(@PathVariable Integer id) {
        Item entity = itemService.findById(id);
        if (entity != null) {
            ModelMapper modelMapper = new ModelMapper();
            ItemModel model = modelMapper.map(entity, ItemModel.class);
            return ResponseMessage.success(model);
        } else {
            return ResponseMessage.error(1, "Data Not Found .");
        }
    }

    @GetMapping
    public ResponseMessage<List<ItemModel>> findAll() {
        List<Item> items = itemService.findAll();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ItemModel>>() {
        }.getType();
        List<ItemModel> models = modelMapper.map(items, type);
        return ResponseMessage.success(models);
    }
}
