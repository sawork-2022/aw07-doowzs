package edu.nju.sa2022.micropos.order;

import edu.nju.sa2022.micropos.models.Order;
import edu.nju.sa2022.micropos.order.dto.OrderDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    List<OrderDto> toOrderDtos(List<Order> orders);

    OrderDto toOrderDto(Order order);

}
