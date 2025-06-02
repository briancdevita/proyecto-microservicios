package order_service.controller;



import order_service.DTO.OrderEvent;
import order_service.model.PurchaseOrder;
import order_service.repository.OrderRepository;
import order_service.service.KafkaProducer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderController {



    private final OrderRepository orderRepository;
    private final KafkaProducer kafkaProducer;

    public OrderController(OrderRepository orderRepository, KafkaProducer kafkaProducer) {
        this.orderRepository = orderRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public PurchaseOrder createOrder(@RequestBody PurchaseOrder order) {
        PurchaseOrder saved = orderRepository.save(order);
        kafkaProducer.sendOrder(new OrderEvent(saved.getProduct(), saved.getQuantity()));
        return saved;

    }


    @GetMapping
    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }


}
