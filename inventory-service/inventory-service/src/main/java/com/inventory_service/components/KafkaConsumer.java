package com.inventory_service.components;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory_service.DTO.OrderEvent;
import com.inventory_service.service.InventoryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final InventoryService inventoryService;
    private final ObjectMapper objectMapper;

    public KafkaConsumer(InventoryService inventoryService, ObjectMapper objectMapper) {
        this.inventoryService = inventoryService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume (String message) {
        try {
            OrderEvent order = objectMapper.readValue(message, OrderEvent.class);
            System.out.println("➡ Pedido recibido: " + order);
            boolean available = inventoryService.isInStock(order.getProduct(), order.getQuantity() );
            System.out.println("✔ ¿Stock disponible?: " + available);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
