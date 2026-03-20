package com.projeto.ecommerce.controller;

import com.projeto.ecommerce.DTOs.OrderRequestDTO;
import com.projeto.ecommerce.DTOs.OrderResponseDTO;
import com.projeto.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service){

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@RequestBody OrderRequestDTO dto) {
        OrderResponseDTO response = service.create(dto);
        return ResponseEntity.ok(response);
    }
}
