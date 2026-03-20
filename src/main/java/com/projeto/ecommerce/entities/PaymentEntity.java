package com.projeto.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class PaymentEntity {
    @Id
    private UUID id;
    private Instant moment;

    @OneToOne
    @MapsId //compartilha a chave primaria
    private OrderEntity order;

}
