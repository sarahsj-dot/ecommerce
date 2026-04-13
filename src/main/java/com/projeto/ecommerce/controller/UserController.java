package com.projeto.ecommerce.controller;

import com.projeto.ecommerce.DTOs.UserRequestDTO;
import com.projeto.ecommerce.DTOs.UserResponseDTO;
import com.projeto.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO response = service.create(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
    }
}
