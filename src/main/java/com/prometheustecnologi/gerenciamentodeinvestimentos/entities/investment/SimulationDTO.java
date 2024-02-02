package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment;

public record SimulationDTO(
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


    public SimulationDTO(CreateSimulationDTO cSimulationDTO, Double valorFinal,
                         Double valorPagoEmTaxa, Double valorInvestido, double rendimento ) {
        this( cSimulationDTO.valorInicial(), valorFinal, cSimulationDTO.valorMensal(),
                cSimulationDTO.taxa(), cSimulationDTO.numeroDeParcelasMensais(),
                cSimulationDTO.taxDesc(), valorPagoEmTaxa, valorInvestido, rendimento );
    }
}
