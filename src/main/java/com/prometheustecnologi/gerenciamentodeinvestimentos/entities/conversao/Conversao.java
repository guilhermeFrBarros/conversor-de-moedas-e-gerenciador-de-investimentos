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

    @JoinColumn(name = "usuario_pk",referencedColumnName = "id")
    @ManyToOne( fetch = FetchType.LAZY)
    private User usuario;

    public Conversao() { }

    public Conversao(Long id, String nome, Double amount, Double maximumPrice, String shortName,
     Double minimumPrice, Double salePrice, Double buyPrice, String imgUrl, String longDescription, User usuario)
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
        this.usuario = usuario;
    }

    public Conversao( ConversionCreateDTO dados, User user ){
        id = dados.id();
        nome = dados.nome();
        amount = dados.amount();
        shortName =  dados.shortName();
        maximumPrice = dados.maximumPrice();
        minimumPrice = dados.minimumPrice();
        salePrice = dados.salePrice();
        buyPrice = dados.buyPrice();
        imgUrl = dados.imgUrl();
        longDescription = dados.longDescription();
        dataDaCotacao = dados.dataDaCotacao();

        usuario = user;
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
