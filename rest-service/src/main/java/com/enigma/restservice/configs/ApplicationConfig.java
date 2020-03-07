package com.enigma.restservice.configs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.enigma.restservice.entities.Item;
import com.enigma.restservice.entities.Stock;
import com.enigma.restservice.entities.Unit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public List<Item> itemBean() {
        List<Item> items = new ArrayList<>();
        return items;
    }

    @Bean
    public List<Unit> unitBean() {
        List<Unit> units = new ArrayList<>();
        units.add(new Unit("kg"));
        units.add(new Unit("g"));
        units.add(new Unit("Pack"));
        units.add(new Unit("Mg"));

        for (Unit unit : units) {
            unit.setCreatedDate(LocalDateTime.now());
        }
        return units;
    }

    @Bean
    public List<Stock> stocksBean(@Qualifier("itemBean") List<Item> items, List<Unit> units) {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(items.get(0), 5, units.get(1)));

        return stocks;

    }

}