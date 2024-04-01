package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersitSimulationDTO(
        @NotNull
        @Negative
        Double valorInicial,
        @NotNull
        @Negative
        Double futureValue,
        @NotNull
        @Negative
        Double valorMensal,
        @NotNull
        @Negative
        Double juros,
        @NotNull
        @Negative
        Integer numeroDeParcelas,
        @NotNull
        @Negative
        Double taxDesc,
        @Negative
        Double valorPagoEmTaxa,
        @Negative
        Double valorInvestido,
        @Negative
        double rendimento,
        String description,
        @NotNull
        Long usuarioId
) {
}
