package com.projeto.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class OrderItem {

    @EmbeddedId
    OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double price;

    public OrderItem(){
    }

    public OrderItem(OrderEntity order, ProductEntity product, int quantity, double price){
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrder(){
        return id.getOrder();
    }

    public void setOrder(OrderEntity order) {
        id.setOrder(order);
    }

    public ProductEntity getProduct(){
        return id.getProduct();
    }

    public void setProduct(ProductEntity product) {
        id.setProduct(product);
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
