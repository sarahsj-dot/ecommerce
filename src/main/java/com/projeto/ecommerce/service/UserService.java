package com.projeto.ecommerce.service;

import com.projeto.ecommerce.DTOs.UserRequestDTO;
import com.projeto.ecommerce.DTOs.UserResponseDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public UserResponseDTO create(UserRequestDTO dto) {
            UserEntity user = new UserEntity();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setPassword(dto.getPassword());

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
}
