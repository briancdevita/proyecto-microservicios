package order_service.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import order_service.DTO.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    public KafkaProducer(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendOrder(OrderEvent orderEvent) {
        try {
            String message = objectMapper.writeValueAsString(orderEvent);
            kafkaTemplate.send("order-topic", message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
