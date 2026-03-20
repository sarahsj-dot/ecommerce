package com.projeto.ecommerce.controller;

import com.projeto.ecommerce.DTOs.UserRequestDTO;
import com.projeto.ecommerce.DTOs.UserResponseDTO;
import com.projeto.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO response = service.create(dto);
        return ResponseEntity.ok(response);
    }

}
