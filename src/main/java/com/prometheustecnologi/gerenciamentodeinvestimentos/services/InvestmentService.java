package com.prometheustecnologi.gerenciamentodeinvestimentos.services;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.CreateSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.SimulationDTO;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {

    public SimulationDTO simulationInvestment(  CreateSimulationDTO cSimulationDTO ) {
        var valInicialEmCadaAno = cSimulationDTO.valorInicial();
        var varlorMensal = cSimulationDTO.valorMensal();
        var taxaJuros = (cSimulationDTO.taxa() / 100) / 12;
        var taxDesconto = cSimulationDTO.taxDesc();
        var numMeses = cSimulationDTO.numeroDeParcelasMensais();



        Double valorFinal = valInicialEmCadaAno;
        double redimentoAnual;
        double redimentoAnualDesc;
        double descontoPago;

        for (int i = 0; i < numMeses; i++) {


            // add valor mensal investido
            valorFinal += varlorMensal;

            // juros
            valorFinal *= ( 1 +  taxaJuros );

            //System.out.println( valorFinal);
            if (( i + 1 ) % 12 == 0 ) {

                redimentoAnual =  valorFinal - valInicialEmCadaAno - ( varlorMensal * 12 );
                 redimentoAnualDesc = redimentoAnual * ( 1 - (taxDesconto/ 100));

                valorFinal -= redimentoAnual;
                valInicialEmCadaAno =  valorFinal + redimentoAnualDesc;
                valorFinal = valInicialEmCadaAno;
                descontoPago = redimentoAnual -  redimentoAnualDesc;
                System.out.println(descontoPago);

                if ( taxDesconto == 0 ) {
                    descontoPago =  0;
                }

            }
        }

        return new SimulationDTO( cSimulationDTO, valorFinal );
    }

    //private SimulationDTO calculandoValorEDesconto( SimulationDTO simulationDTO ){

    //}


}
