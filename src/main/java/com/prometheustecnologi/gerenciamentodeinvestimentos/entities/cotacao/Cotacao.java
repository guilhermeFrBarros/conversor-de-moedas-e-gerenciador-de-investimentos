package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.cotacao;

import lombok.Getter;

import java.time.LocalDate;



@Getter
public class Cotacao {

    private String nome;
    private String shortName;
    private Double maximumPrice;
    private Double minimumPrice;
    private Double salePrice;
    private Double buyPrice;
    private LocalDate DataCotacao = LocalDate.now();
    
    public Cotacao(String nome, String shortName, Double maximumPrice, Double minimumPrice, Double salePrice, Double buyPrice) 
    {
        this.nome = nome;
        this.shortName = shortName;
        this.maximumPrice = maximumPrice;
        this.minimumPrice = minimumPrice;
        this.salePrice = salePrice;
        this.buyPrice = buyPrice;
        
    }
    

    // getters
}
