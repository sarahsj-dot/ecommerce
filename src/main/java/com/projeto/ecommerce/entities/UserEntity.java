package com.projeto.ecommerce.entities;

import com.projeto.ecommerce.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
//  Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;

    @ElementCollection  //cria uma tabela auxiliar para armazenar os valores da lista
    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roles = new ArrayList<>();

    //relacionamento 1:N com o order
    @OneToMany(mappedBy = "client")
//  Criando uma lista pra mostrar todos os pedidos dos Usuários
    private List<OrderEntity> orders = new ArrayList<>();
}
