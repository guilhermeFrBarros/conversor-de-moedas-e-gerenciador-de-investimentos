package com.prometheustecnologi.gerenciamentodeinvestimentos.entities;

import java.time.LocalDate;
import java.util.Objects;

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
    private Double cotacaoMaxima;
    private Double cotacaoMinima;
    private Double cotacaoVenda;
    private Double cotacaoCompra;
    private String imgUrl;
    private String longDrescription;
    // private LocalDate data;

    public Convercao() { }

    public Convercao(Long id, String nome, Double cotacaoMaxima,
     Double cotacaoMinima, Double cotacaoVenda, Double cotacaoCompra, String imgUrl, String longDrescription) 
    {
        this.id = id;
        this.nome = nome;
        this.cotacaoMaxima = cotacaoMaxima;
        this.cotacaoMinima = cotacaoMinima;
        this.cotacaoVenda = cotacaoVenda;
        this.cotacaoCompra = cotacaoCompra;
        this.imgUrl = imgUrl;
        this.longDrescription = longDrescription;
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

    public Convercao nome(String nome) 
    {
        setNome(nome);
        return this;
    }

    public Double getCotacaoMaxima() 
    {
        return this.cotacaoMaxima;
    }

    public void setCotacaoMaxima(Double cotacaoMaxima) 
    {
        this.cotacaoMaxima = cotacaoMaxima;
    }

    public Convercao cotacaoMaxima(Double cotacaoMaxima) 
    {
        setCotacaoMaxima(cotacaoMaxima);
        return this;
    }

    public Double getCotacaoMinima() 
    {
        return this.cotacaoMinima;
    }

    public void setCotacaoMinima(Double cotacaoMinima) 
    {
        this.cotacaoMinima = cotacaoMinima;
    }

    public Convercao cotacaoMinima(Double cotacaoMinima) 
    {
        setCotacaoMinima(cotacaoMinima);
        return this;
    }

    public Double getCotacaoVenda() 
    {
        return this.cotacaoVenda;
    }

    public void setCotacaoVenda(Double cotacaoVenda) 
    {
        this.cotacaoVenda = cotacaoVenda;
    }

    public Convercao cotacaoVenda(Double cotacaoVenda) 
    {
        setCotacaoVenda(cotacaoVenda);
        return this;
    }

    public Double getCotacaoCompra() 
    {
        return this.cotacaoCompra;
    }

    public void setCotacaoCompra(Double cotacaoCompra) 
    {
        this.cotacaoCompra = cotacaoCompra;
    }

    public Convercao cotacaoCompra(Double cotacaoCompra) 
    {
        setCotacaoCompra(cotacaoCompra);
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
        return this.longDrescription;
    }

    public void setLongDrescription(String longDrescription) 
    {
        this.longDrescription = longDrescription;
    }

   
    public Convercao longDrescription(String longDrescription) 
    {
        setLongDrescription(longDrescription);
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
