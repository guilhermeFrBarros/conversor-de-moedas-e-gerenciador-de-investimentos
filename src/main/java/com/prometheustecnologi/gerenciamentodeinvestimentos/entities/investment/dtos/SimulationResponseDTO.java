package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.CreateSimulationDTO;

public record SimulationResponseDTO(
        Double valorInicial,
        Double futureValue,
        Double valorMensal,
        Double juros,
        Integer numeroDeParcelas,
        Double taxDesc,
        Double valorPagoEmTaxa,
        Double valorInvestido,
        double rendimento
) {


    public SimulationResponseDTO(CreateSimulationDTO cSimulationDTO, Double valorFinal,
                                 Double valorPagoEmTaxa, Double valorInvestido, double rendimento ) {
        this( cSimulationDTO.valorInicial(), valorFinal, cSimulationDTO.valorMensal(),
                cSimulationDTO.taxa(), cSimulationDTO.numeroDeParcelasMensais(),
                cSimulationDTO.taxDesc(), valorPagoEmTaxa, valorInvestido, rendimento );
    }
}
