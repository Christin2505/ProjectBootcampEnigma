package com.enigma.restservice.services;

import java.util.List;

import com.enigma.restservice.entities.Item;

public interface ItemService {

    public Item add(Item entity);

    public Item edit(Item entity);

    public Item removeById(Integer id);

    public Item findById(Integer id);

    public List<Item> findAll();
}