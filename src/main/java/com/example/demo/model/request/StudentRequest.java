package com.example.demo.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {
    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Name is mandatory")
    private String surname;

    @NotNull(message = "Email is mandatory")
    private String email;

    @NotNull(message = "CPF is mandatory")
    private String cpf;

    @NotNull(message = "RG is mandatory")
    private String rg;
}
