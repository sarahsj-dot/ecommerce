package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.StatusDoPedido;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class OrderResponseDTO {
    private UUID id;
    private Instant moment;
    private StatusDoPedido status;
    private UUID clientId;
    private List<OrderItemDTO> items; //lista de itens do pedido

    public OrderResponseDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
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
