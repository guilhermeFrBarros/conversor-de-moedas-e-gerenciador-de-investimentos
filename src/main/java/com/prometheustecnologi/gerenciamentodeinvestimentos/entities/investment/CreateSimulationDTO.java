package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment;

public record CreateSimulationDTO(
        Double valorInicial,
        Double valorMensal,
        Double taxa,
        Integer numeroDeParcelasMensais,
        Double taxDesc
) {
}
