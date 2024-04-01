package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.investment.dtos.PersitSimulationDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Entity
@Table( name = "tb_Simulation" )
public class InvestmentSimulation {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long Id;

    private Double futureValue;
    
    private Double valorRegular;
    private Double juros;
    private Integer numeroDeParcelas;
    private Double valorInicial;
    private Double taxaDesc;
    private Double valorPagoEmTaxa;
    private Double valorInvestido;
    private Double rendimento;
    private LocalDate dataDaSimulacao;
    private String description;

    @JoinColumn(name = "usuario_pk")
    @ManyToOne( fetch = FetchType.LAZY )
    private User usuario;

    public InvestmentSimulation(PersitSimulationDTO dadosDTO, User user) {
        this.futureValue = dadosDTO.futureValue();
        this.valorRegular = dadosDTO.valorMensal();
        this.juros = dadosDTO.juros();
        this.numeroDeParcelas = dadosDTO.numeroDeParcelas();
        this.valorInicial = dadosDTO.valorInicial();
        this.taxaDesc = dadosDTO.taxDesc();
        this.valorPagoEmTaxa = dadosDTO.valorPagoEmTaxa();
        this.valorInvestido = dadosDTO.valorInvestido();
        this.rendimento = dadosDTO.rendimento();
        this.dataDaSimulacao = LocalDate.now();
        this.description = dadosDTO.description();
        this.usuario = user;
    }


}
