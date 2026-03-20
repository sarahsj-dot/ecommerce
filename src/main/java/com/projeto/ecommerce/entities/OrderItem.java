package com.projeto.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItem {

    @EmbeddedId
    OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double price;

    public OrderItem(OrderEntity order, ProductEntity product, int quantity, double price){
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    //retorna o order para qual o item pertence, associando a chave composta
    public OrderEntity getOrder() { return id.getOrder(); }

    public void setOrder(OrderEntity order) { id.setOrder(order); }

    //retorna o product do item, associando a chave composta
    public ProductEntity getProduct() { return id.getProduct(); }

    public void setProduct(ProductEntity product) { id.setProduct(product); }
}
