package com.notification_service.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification_service.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consume(String message) {
        try {
            OrderEvent order = objectMapper.readValue(message, OrderEvent.class);
            System.out.println("🔔 Notificacion: Se realizo un pedido de " + order.getQuantity() + "unidad(es) de " + order.getProduct() );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
