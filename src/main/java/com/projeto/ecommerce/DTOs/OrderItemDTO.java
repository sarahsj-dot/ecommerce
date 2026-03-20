package com.projeto.ecommerce.DTOs;

import java.util.UUID;


public class OrderItemDTO {

    private UUID productId;
    private int quantity;
    private double price;

    public OrderItemDTO() {}

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
