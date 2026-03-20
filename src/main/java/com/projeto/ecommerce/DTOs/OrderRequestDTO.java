package com.projeto.ecommerce.DTOs;

import java.util.List;

import java.time.LocalDate;
import java.util.UUID;

public class OrderRequestDTO {
    private List<OrderItemDTO> items;

    private UUID clientId;

    public OrderRequestDTO(){}

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

}
