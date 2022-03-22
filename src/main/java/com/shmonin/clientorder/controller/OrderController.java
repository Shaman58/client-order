package com.shmonin.clientorder.controller;

import com.shmonin.clientorder.dto.OrderDto;
import com.shmonin.clientorder.model.Order;
import com.shmonin.clientorder.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PutMapping("/client/{clientId}")
    public OrderDto save(@RequestBody Order order, @PathVariable Long clientId) {
        return orderService.save(order, clientId);
    }

    @GetMapping("/client/{clientId}")
    public List<OrderDto> findAllByClientId(@PathVariable Long clientId) {
        return orderService.getAllByClientId(clientId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}