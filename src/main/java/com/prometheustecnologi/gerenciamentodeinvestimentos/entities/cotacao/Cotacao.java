package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.cotacao;

import java.time.LocalDate;



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
    public String getNome() {
        return this.nome;
    }

    public String getShortName() {
        return this.shortName;
    }

    public Double getMaximumPrice() {
        return this.maximumPrice;
    }

    public Double getMinimumPrice() {
        return this.minimumPrice;
    }

    public Double getSalePrice() {
        return this.salePrice;
    }

    public Double getBuyPrice() {
        return this.buyPrice;
    }

    public LocalDate getDataCotacao() {
        return this.DataCotacao;
    }
}
