package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(@NotBlank String email, @NotNull String senha ) {
}