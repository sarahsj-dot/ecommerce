package com.projeto.ecommerce.DTOs;

import java.time.LocalDate;
import java.util.UUID;

public class OrderRequestDTO {
    private long id;
    private LocalDate moment;
    private UUID client;

    public OrderRequestDTO(){

    }
}
