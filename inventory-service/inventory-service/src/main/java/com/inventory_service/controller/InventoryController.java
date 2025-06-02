package com.inventory_service.controller;


import com.inventory_service.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkStock (
            @RequestParam String product,
            @RequestParam int quantity
    ) {
        boolean available = inventoryService.isInStock(product, quantity);
        if (available) {
            return ResponseEntity.ok("Stock available");
        }
        else {
            return ResponseEntity.ok("Stock not available");
        }
    }
}
