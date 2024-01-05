package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.simulation;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table( name = "tb_Simulation" )
public class InvestmentSimulation {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Double futureValue;
    
    private Double valorRegular;
    private Double taxa;
    private Integer numeroDeParcelas;
    private Double valorPresente;

    @JoinColumn(name = "usuario_pk")
    @ManyToOne( fetch = FetchType.LAZY)
    private User usuario;

    public InvestmentSimulation(Double futureValue, Double valorRegular,
                                Double taxa, Integer numeroDeParcelas, Double valorPresente) {

        this.futureValue = futureValue;
        this.valorRegular = valorRegular;
        this.taxa = taxa;
        this.numeroDeParcelas = numeroDeParcelas;
        this.valorPresente = valorPresente;
    }
}
