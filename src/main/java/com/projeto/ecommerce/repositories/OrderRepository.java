package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.entities.OrderEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

Optional<Order> findAllBy(UUID id);
}
