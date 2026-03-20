package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.StatusDoPedido;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class OrderResponseDTO {
    private UUID id;
    private LocalDate moment;
    private StatusDoPedido status;
    private UUID clientId;
    private List<OrderItemDTO> items;

    public OrderResponseDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

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
