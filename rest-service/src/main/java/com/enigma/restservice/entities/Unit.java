package com.enigma.restservice.entities;

import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Entity;

@Table(name = "unit")
@Entity

public class Unit extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Unit{" + "name=" + name + '}';
    }
}
