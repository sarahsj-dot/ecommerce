package com.projeto.ecommerce.service;

import com.projeto.ecommerce.DTOs.OrderRequestDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public OrderRequestDTO create(OrderRequestDTO dto){
        OrderEntity order = new OrderEntity();
        order.setMoment(LocalDate.now());
        order.getClient(UUID)
        return
    }


}
