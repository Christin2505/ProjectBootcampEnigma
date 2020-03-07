package com.enigma.restservice.entities;

import javax.persistence.*;
import javax.persistence.Entity;

@Table(name = "item")
@Entity
public class Item extends AbstractEntity {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "}";
    }
}
