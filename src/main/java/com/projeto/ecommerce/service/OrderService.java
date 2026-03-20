package com.projeto.ecommerce.service;

import com.projeto.ecommerce.DTOs.OrderItemDTO;
import com.projeto.ecommerce.DTOs.OrderRequestDTO;
import com.projeto.ecommerce.DTOs.OrderResponseDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.OrderItem;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.ProductRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public OrderResponseDTO create(OrderRequestDTO dto){
        //Busca o cliente pelo id
        UserEntity client = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        //Cria o pedido
        OrderEntity order = new OrderEntity();
        order.setMoment(LocalDate.now());
        order.setStatus(StatusDoPedido.AWAITING_PAYMENT);
        order.setClient(client);

        //Salva o pedido para gerar o id antes de conectar os itens
        order = orderRepository.save(order);

        //Adiciona os itens ao pedido
        for (OrderItemDTO itemDTO : dto.getItems()){
            ProductEntity product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.getProductId()));
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), itemDTO.getPrice());
            order.getItems().add(item);
        }

        order = orderRepository.save(order);

        return toResponseDTO(order);
    }

    private OrderResponseDTO toResponseDTO(OrderEntity order) {
        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(order.getId());
        response.setMoment(order.getMoment());
        response.setStatus(order.getStatus());
        response.setClientId(order.getClient().getId());

        List<OrderItemDTO> itemDTOs = order.getItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setProductId(item.getProduct().getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());
            return itemDTO;
        }).toList();

        response.setItems(itemDTOs);
        return response;

    }


}
