package com.projeto.ecommerce.entities;

import com.projeto.ecommerce.enums.StatusDoPedido;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Instant moment; //momento exato da criação do pedido
    private StatusDoPedido status;

    //Relacionamento N:1 com o user
    @ManyToOne
//  define qual coluna será usada como chave estrangeira na tabela
    @JoinColumn(name  = "cliente_id")
    private UserEntity client;

    //Relacionamento de 1:1 com o payment
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // cascade para garantir o payment é salvo ou deletado com o order
    private PaymentEntity payment;

    //relacionamento de 1:N com o orderItem
    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL) //cascade all para que os itens sejam persistidos com o order
    private Set<OrderItem> items = new HashSet<>();

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items){
        this.items = items;
    }

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

    public UserEntity getClient() {
        return client;
    }

    public void setClient(UserEntity client) {
        this.client = client;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
}
