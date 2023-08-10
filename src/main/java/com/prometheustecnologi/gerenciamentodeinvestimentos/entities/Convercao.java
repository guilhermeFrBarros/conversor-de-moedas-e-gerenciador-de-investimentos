package com.prometheustecnologi.gerenciamentodeinvestimentos.entities;

// import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_convercao")
public class Convercao {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String shortName;
    private Double amount;
    private Double maximumPrice;
    private Double minimumPrice; 
    private Double salePrice; 
    private Double buyPrice; 
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String longDescription;
    // private LocalDate data;

    public Convercao() { }

    public Convercao(Long id, String nome, Double amount, Double maximumPrice, String shortName,
     Double minimumPrice, Double salePrice, Double buyPrice, String imgUrl, String longDescription) 
    {
        this.id = id;
        this.nome = nome;
        this.amount = amount;
        this.shortName = shortName;
        this.maximumPrice = maximumPrice;
        this.minimumPrice = minimumPrice;
        this.salePrice = salePrice;
        this.buyPrice = buyPrice;
        this.imgUrl = imgUrl;
        this.longDescription = longDescription;
    }

   
    public Long getId() 
    {
        return this.id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Convercao id(Long id) 
    {
        setId(id);
        return this;
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    } 

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) 
    {
        this.shortName = shortName;
    }

    public Double getAmount() {
        return  this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMaximumPrice() 
    {
        return this.maximumPrice;
    }

    public void setMaximumPrice(Double maximumPrice) 
    {
        this.maximumPrice = maximumPrice;
    }

    public Convercao maximumPrice(Double maximumPrice) 
    {
        setMaximumPrice(maximumPrice);
        return this;
    }

    public Double getMinimumPrice() 
    {
        return this.minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) 
    {
        this.minimumPrice = minimumPrice;
    }

    public Convercao minimumPrice(Double minimumPrice) 
    {
        setMinimumPrice(minimumPrice);
        return this;
    }

    public Double getSalePrice() 
    {
        return this.salePrice;
    }

    public void setSalePrice(Double salePrice) 
    {
        this.salePrice = salePrice;
    }

    public Convercao salePrice(Double salePrice) 
    {
        setSalePrice(salePrice);
        return this;
    }

    public Double getBuyPrice() 
    {
        return this.buyPrice;
    }

    public void setBuyPrice(Double buyPrice) 
    {
        this.buyPrice = buyPrice;
    }

    public Convercao buyPrice(Double buyPrice) 
    {
        setBuyPrice(buyPrice);
        return this;
    }

    public String getImgUrl() 
    {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public Convercao imgUrl(String imgUrl) 
    {
        setImgUrl(imgUrl);
        return this;
    }

    public String getLongDrescription() 
    {
        return this.longDescription;
    }

    public void setLongDrescription(String longDescription) 
    {
        this.longDescription = longDescription;
    }

   
    public Convercao longDescription(String longDescription) 
    {
        setLongDrescription(longDescription);
        return this;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Convercao other =  (Convercao) obj;
        return Objects.equals(id, other.id);
    }
        
}
