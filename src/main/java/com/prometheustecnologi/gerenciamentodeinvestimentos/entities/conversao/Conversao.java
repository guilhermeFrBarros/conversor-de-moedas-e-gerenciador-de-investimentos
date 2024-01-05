package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao;

import java.time.LocalDate;
// import java.time.LocalDate;
import java.util.Objects;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_convercao")
public class Conversao {

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
    private LocalDate dataDaCotacao;

    @JoinColumn(name = "usuario_pk")
    @ManyToOne( fetch = FetchType.LAZY)
    private User usuario;

    public Conversao() { }

    public Conversao(Long id, String nome, Double amount, Double maximumPrice, String shortName,
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

    public Conversao id(Long id) 
    {
        setId(id);
        return this;
    }



    public Conversao maximumPrice(Double maximumPrice) 
    {
        setMaximumPrice(maximumPrice);
        return this;
    }

    public Conversao minimumPrice(Double minimumPrice) 
    {
        setMinimumPrice(minimumPrice);
        return this;
    }

    public Conversao salePrice(Double salePrice) 
    {
        setSalePrice(salePrice);
        return this;
    }

    public Conversao buyPrice(Double buyPrice) 
    {
        setBuyPrice(buyPrice);
        return this;
    }

    public Conversao imgUrl(String imgUrl) 
    {
        setImgUrl(imgUrl);
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
        Conversao other =  (Conversao) obj;
        return Objects.equals(id, other.id);
    }
        
}
