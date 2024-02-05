package com.prometheustecnologi.gerenciamentodeinvestimentos.services;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.*;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.CreateSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.PersitSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.SimulationResponseDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.InvestimentSimulationRepository;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InvestmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvestimentSimulationRepository simulationRepository;

    public SimulationResponseDTO simulationInvestment(CreateSimulationDTO cSimulationDTO ) {

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



    private SimulationResponseDTO calcularDescontoEValorFinal(double valorFinal, CreateSimulationDTO cSimulationDTO){

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

        return new SimulationResponseDTO( cSimulationDTO, valorFinal,
                valorPagoEmTaxa, valorInvestido, redimentoAnualDesc );
    }


    @Transactional
    public InvestmentSimulation create(PersitSimulationDTO persitSimulationDTO) {
        var user = userRepository.getReferenceById( persitSimulationDTO.usuarioId() );
        InvestmentSimulation investmentSimulation = new InvestmentSimulation( persitSimulationDTO, user );

        return simulationRepository.save( investmentSimulation );
    }

    @Transactional
    public InvestmentSimulation detalhar(Long id) {
        var simulation = simulationRepository.findById( id ).orElseThrow();

        return  simulation;
    }

    public void deletar(Long id) {
        simulationRepository.deleteById( id );
    }
}
