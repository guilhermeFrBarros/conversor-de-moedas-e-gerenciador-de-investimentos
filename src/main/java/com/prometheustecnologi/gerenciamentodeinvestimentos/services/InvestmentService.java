package com.prometheustecnologi.gerenciamentodeinvestimentos.services;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.CreateSimulationDTO;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.SimulationDTO;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {

    public SimulationDTO simulationInvestment(CreateSimulationDTO cSimulationDTO ) {

        var valInicialEmCadaAno = cSimulationDTO.valorInicial();
        var varlorMensal = cSimulationDTO.valorMensal();
        var taxaJuros = (cSimulationDTO.taxa() / 100) / 12;
        var numMeses = cSimulationDTO.numeroDeParcelasMensais();

        Double valorFuturo = valInicialEmCadaAno;
        for (int i = 0; i < numMeses; i++) {


            //  valor mensal investido
            valorFuturo += varlorMensal;

            // juros
            valorFuturo *= ( 1 +  taxaJuros );

            if (( i + 1 ) == numMeses ) { }
        }
        System.out.println(valorFuturo);

        return calcularDescontoEValorFinal( valorFuturo, cSimulationDTO );
    }



    private SimulationDTO calcularDescontoEValorFinal( double valorFinal,CreateSimulationDTO cSimulationDTO){

        var valInicial = cSimulationDTO.valorInicial();
        var valorMensal = cSimulationDTO.valorMensal();
        var taxDesconto = cSimulationDTO.taxDesc();
        var numParcelas = cSimulationDTO.numeroDeParcelasMensais();

        var valorInvestido = valInicial + ( valorMensal *  numParcelas );
        var redimentoAnual =  valorFinal -  valorInvestido;
        var redimentoAnualDesc = redimentoAnual * ( 1 - (taxDesconto/ 100));

        valorFinal -= redimentoAnual;
        valorFinal =  valorFinal + redimentoAnualDesc;
        var valorPagoEmTaxa = redimentoAnual -  redimentoAnualDesc;

        return new SimulationDTO( cSimulationDTO, valorFinal,
                valorPagoEmTaxa, valorInvestido, redimentoAnualDesc );
    }



}
