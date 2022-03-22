package com.shmonin.clientorder.service;

import com.shmonin.clientorder.dto.OrderDto;
import com.shmonin.clientorder.exception.EntityNotFoundException;
import com.shmonin.clientorder.model.Order;
import com.shmonin.clientorder.repository.ClientRepository;
import com.shmonin.clientorder.repository.OrderRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.shmonin.clientorder.exception.ExceptionMessage.CLIENT;
import static com.shmonin.clientorder.exception.ExceptionMessage.ORDER;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public List<OrderDto> getAllByClientId(Long clientId) {
        return toDto(orderRepository.getAllByClientId(clientId));
    }

    public OrderDto getById(Long id) {
        ORDER.getMessage(id);
        return toDto(orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ORDER.getMessage(id))));
    }

    public OrderDto save(Order order, Long clientId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException(CLIENT.getMessage(clientId)));
        order.setClient(client);
        return toDto(orderRepository.save(order));
    }

    public void deleteById(Long id) {
        getById(id);
        orderRepository.deleteById(id);
    }

    public OrderDto toDto(Order order) {
        var orderDto = new OrderDto();
        orderDto.setDate(order.getDate());
        orderDto.setDetails(order.getDetails());
        orderDto.setAmount(order.getAmount());
        return orderDto;
    }

    public List<OrderDto> toDto(List<Order> orders) {
        return orders.stream().map(this::toDto).collect(toList());
    }
}
