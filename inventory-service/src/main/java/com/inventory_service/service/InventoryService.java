package com.inventory_service.service;


import com.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean isInStock (String product, int requestQuantity) {
        return inventoryRepository.findByProduct(product)
                .map( i -> i.getQuantity() >= requestQuantity)
                .orElse(false);
    }
}
