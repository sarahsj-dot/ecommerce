package com.projeto.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class OrderItem {

    @EmbeddedId
    OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double price;

    public OrderItem(OrderEntity order, ProductEntity product, int quantity, double price){
        id.setOrderEntity(order);
        id.setProductEntity(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrderEntity(){
        return getOrderEntity();
    }

    public ProductEntity getProductEntity(){
        return getProductEntity();
    }
    public void setOrderEntity(OrderEntity order) {
        id.setOrderEntity((order));
    }

    public void setProductEntity(ProductEntity product) {
        id.setProductEntity(product);
    }

}
