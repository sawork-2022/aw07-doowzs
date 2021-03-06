package edu.nju.sa2022.micropos.delivery;

import edu.nju.sa2022.micropos.models.Delivery;
import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.services.DeliveryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DeliveryConfiguration {

    @Bean
    public DeliveryService deliveryService(DeliveryRepository deliveryRepository) {
        return new DeliveryServiceImpl(deliveryRepository);
    }

    @Bean
    public Consumer<Order> createDelivery(DeliveryService deliveryService) {
        return (order) -> {
            Delivery delivery = Delivery.builder()
                    .orderId(order.getId())
                    .delivered(true)
                    .build();
            deliveryService.createDelivery(delivery);
        };
    }

}
