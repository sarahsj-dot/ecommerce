package com.projeto.ecommerce.controller;

import com.projeto.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service){
        this.service = service;
    }

//    @PostMapping
//    public ResponseEntity <?> {
//        service
//    }
}
