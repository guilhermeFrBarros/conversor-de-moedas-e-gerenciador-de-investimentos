package com.prometheustecnologi.gerenciamentodeinvestimentos.repositories;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.InvestmentSimulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentSimulationRepository extends JpaRepository<InvestmentSimulation, Long > {
}
