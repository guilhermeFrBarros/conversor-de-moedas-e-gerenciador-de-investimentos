package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.*;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.CreateSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.DetalSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.PersitSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.SimulationResponseDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;
    @PostMapping("/simulation")
    public ResponseEntity<SimulationResponseDTO> simulation(@RequestBody CreateSimulationDTO simulationDTO ) {
        var simulationDTOResponse = investmentService.simulationInvestment( simulationDTO );

        return ResponseEntity.ok( simulationDTOResponse );
    }

    @PostMapping
    public ResponseEntity create( @RequestBody PersitSimulationDTO persitSimulationDTO ){
        InvestmentSimulation simulation = investmentService.create( persitSimulationDTO );
        var detalSimulation = new DetalSimulationDTO( simulation );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand( detalSimulation.id() ).toUri();

        return ResponseEntity.created( uri ).body( detalSimulation );
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar( @PathVariable Long id ) {
        investmentService.deletar( id );

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar( @PathVariable Long id ) {
        var simulation = investmentService.detalhar( id );
        DetalSimulationDTO detalSimulationDTO = new DetalSimulationDTO( simulation );
        return  ResponseEntity.ok( detalSimulationDTO );
    }

}
