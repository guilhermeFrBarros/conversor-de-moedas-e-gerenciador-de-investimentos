package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.cotacao;

public record DTODadosCotacaoRetorno(
        
         String shortName,
         Double maximumPrice, 
         Double minimumPrice, 
         Double salePrice, 
         Double buyPrice) {
        public DTODadosCotacaoRetorno ( Cotacao cotacao ) {
                this(cotacao.getShortName() , cotacao.getMaximumPrice(), cotacao.getMinimumPrice(), 
                cotacao.getSalePrice(), cotacao.getBuyPrice());
        }
}