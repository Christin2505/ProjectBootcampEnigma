package com.enigma.restservice.entities;

import javax.persistence.*;

@Table(name = "stock")
@Entity

public class Stock extends AbstractEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item item;

    private int quantity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Unit unit;

    public Stock() {
    }

    public Stock(Item item, int quantity, Unit unit) {
        this.item = item;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Stock{ item=" + item + ", quantity=" + quantity + ", unit=" + unit + '}';
    }
}
