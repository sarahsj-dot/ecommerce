package com.projeto.ecommerce.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class UserRequestDTO {
    @NotBlank(message = "O nome não pode estar vazio, preencha esse campo corretamente")
    private String name;
    @Email(message = "Email invalido")
    private String email;
    @Size(min = 12, max = 12, message = "O número de telefone deve ter no maximo 12 números")
    private String phone;
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    private String password;

}
