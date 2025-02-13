package com.icc.reservations_springboot.controller;

import com.icc.reservations_springboot.model.Price;
import com.icc.reservations_springboot.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceService service;

    @GetMapping
    public List<Price> getAllPrices() {
        return service.getAllPrices();
    }

    @GetMapping("/{id}")
    public Price getPrice(@PathVariable Long id) {
        return service.getPrice(id);
    }

    @PostMapping
    public void addPrice(@RequestBody Price price) {
        service.addPrice(price);
    }

    @PutMapping("/{id}")
    public void updatePrice(@PathVariable Long id, @RequestBody Price price) {
        service.updatePrice(id, price);
    }

    @DeleteMapping("/{id}")
    public void deletePrice(@PathVariable Long id) {
        service.deletePrice(id);
    }
}
