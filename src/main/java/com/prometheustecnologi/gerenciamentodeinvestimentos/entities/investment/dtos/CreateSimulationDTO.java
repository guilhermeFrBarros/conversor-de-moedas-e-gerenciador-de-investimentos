package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotNull;

public record CreateSimulationDTO(
        @NotNull
        @Negative
        Double valorInicial,
        @NotNull
        @Negative
        Double valorMensal,
        @NotNull
        @Negative
        Double taxa,
        @NotNull
        @Negative
        Integer numeroDeParcelasMensais,
        @NotNull
        @Negative
        Double taxDesc
) {
}
