package com.icc.reservations_springboot.service;

import com.icc.reservations_springboot.model.Price;
import com.icc.reservations_springboot.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository repository;

    public List<Price> getAllPrices() {
        List<Price> prices = new ArrayList<>();
        repository.findAll().forEach(prices::add);
        return prices;
    }

    public Price getPrice(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void addPrice(Price price) {
        repository.save(price);
    }

    public void updatePrice(Long id, Price price) {
        repository.save(price);
    }

    public void deletePrice(Long id) {
        repository.deleteById(id);
    }
}
