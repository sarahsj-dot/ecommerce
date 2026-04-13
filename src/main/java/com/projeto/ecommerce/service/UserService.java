package com.projeto.ecommerce.service;

import com.projeto.ecommerce.DTOs.UserRequestDTO;
import com.projeto.ecommerce.DTOs.UserResponseDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.ProductRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final ProductRepository productRepository;

        public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ProductRepository productRepository) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.productRepository = productRepository;
        }

        public UserResponseDTO create(UserRequestDTO dto) {
            UserEntity user = new UserEntity();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user = userRepository.save(user);

            return toResponseDTO(user);
        }

        private UserResponseDTO toResponseDTO(UserEntity user) {
            return new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone()
            );
        }

    public UserResponseDTO deleteUser(UUID dto) {
            UserEntity user =new UserEntity();

            return toResponseDTO(user);
    }
}
