package com.enigma.restservice.services.implement;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import com.enigma.restservice.entities.Item;
import com.enigma.restservice.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private List<Item> entities;

    @PostConstruct
    public void init() {
        add(new Item("Beras"));
        add(new Item("Gula"));
        add(new Item("Minyak Goreng"));
        add(new Item("Kopi"));

    }

    public int nextId() {
        int i = 1;
        for (Item entity : entities) {
            if (entity.getId() != i) {
                return i;
            }
            i++;
        }
        return i;
    }

    @Override
    public Item add(Item entity) {
        entity.setId(nextId());
        entity.setCreatedDate(LocalDateTime.now());
        entities.add(entity);
        return entity;
    }

    @Override
    public Item edit(Item entity) {
        Item item = findById(entity.getId());
        item.setName(entity.getName());
        entity.setCreatedDate(LocalDateTime.now());

        return item;

    }

    @Override
    public Item removeById(Integer id) {
        Iterator<Item> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId().equals(id)) {
                iterator.remove();
                return item;
            }
        }
        return null;
    }

    @Override
    public Item findById(Integer id) {
        for (Item item : entities) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> findAll() {
        return entities;
    }

}