package com.prometheustecnologi.gerenciamentodeinvestimentos.entities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.time.LocalDate;

import org.json.JSONObject;

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
