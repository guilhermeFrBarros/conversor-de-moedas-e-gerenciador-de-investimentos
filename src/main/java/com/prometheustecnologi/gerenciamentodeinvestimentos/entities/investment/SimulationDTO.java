package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment;

public record SimulationDTO(
        Double valorInicial,
        Double futureValue,
        Double valorMensal,
        Double taxa,
        Integer numeroDeParcelas,
        Double taxDesc
) {


    public SimulationDTO(CreateSimulationDTO simulationDTO, Double valorFinal) {
        this(simulationDTO.valorInicial(), valorFinal, simulationDTO.valorMensal(),
                simulationDTO.taxa(), simulationDTO.numeroDeParcelasMensais(),
                simulationDTO.taxDesc());
    }
}
