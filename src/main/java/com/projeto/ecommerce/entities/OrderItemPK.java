package com.projeto.ecommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

//implementa Serializable: obrigatório pelo JPA para classes @Embeddable usadas como chave composta
@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne //relacionamento N:1 com o order
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne //relacionamento N:1 com o product
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    // equals e hashCode são obrigatorios para que o JPA compare chaves compostas corretamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK)) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}