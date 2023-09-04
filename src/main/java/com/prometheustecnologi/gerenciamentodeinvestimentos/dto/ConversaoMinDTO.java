package com.prometheustecnologi.gerenciamentodeinvestimentos.dto;

import java.time.LocalDate;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.Conversao;


public class ConversaoMinDTO {

    private Long id;
    private String shortName;
    private Double amount;
    private Double buyPrice; 
    private String imgUrl;
    private LocalDate dataDaCotacao;


    public ConversaoMinDTO() {}
    
    public ConversaoMinDTO( Conversao entity) 
    {
        this.id = entity.getId();
        this.shortName = entity.getShortName();
        this.amount = entity.getAmount();
        this.buyPrice = entity.getBuyPrice();
        this.imgUrl = entity.getImgUrl();
        this.dataDaCotacao = entity.getDataDaCotacao();
    }

    public Long getId() 
    {
        return this.id;
    }

    public String getShortName() 
    {
        return this.shortName;
    }

    public Double getAmount() 
    {
        return this.amount;
    }
    
    public Double getBuyPrice() 
    {
        return this.buyPrice;
    }
    
    public String getImgUrl() 
    {
        return this.imgUrl;
    }

    public LocalDate getDataDaCotacao() {
        return this.dataDaCotacao;
    }
}
