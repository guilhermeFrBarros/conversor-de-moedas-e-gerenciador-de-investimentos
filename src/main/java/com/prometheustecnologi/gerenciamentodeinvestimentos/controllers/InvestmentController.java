package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.CreateSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.InvestmentSimulation;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.SimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;
    @PostMapping("/simulation")
    public ResponseEntity<SimulationDTO> simulation( @RequestBody CreateSimulationDTO simulationDTO ) {
        var simulationDTOResponse = investmentService.simulationInvestment( simulationDTO );

        return ResponseEntity.ok( simulationDTOResponse );
    }

}
