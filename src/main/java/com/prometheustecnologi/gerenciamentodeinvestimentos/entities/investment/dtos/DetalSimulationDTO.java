package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.InvestmentSimulation;

import java.time.LocalDate;

public record DetalSimulationDTO(

        Long id,
        Double valorInicial,
        Double futureValue,
        Double valorMensal,
        Double juros,
        Integer numeroDeParcelas,
        Double taxDesc,
        Double valorPagoEmTaxa,
        Double valorInvestido,
        double rendimento,

        LocalDate data,
        Long usuarioId
) {
    public DetalSimulationDTO(InvestmentSimulation iSimulation) {
        this( iSimulation.getId(), iSimulation.getValorInicial(), iSimulation.getFutureValue(),
                iSimulation.getValorRegular(), iSimulation.getJuros(), iSimulation.getNumeroDeParcelas(),
                iSimulation.getTaxaDesc(), iSimulation.getValorPagoEmTaxa(), iSimulation.getValorInvestido(),
                iSimulation.getRendimento(), iSimulation.getDataDaSimulacao(), iSimulation.getUsuario().getId()
                );
    }
}
