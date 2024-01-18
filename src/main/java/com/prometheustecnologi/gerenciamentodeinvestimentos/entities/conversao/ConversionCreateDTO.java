package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ConversionCreateDTO(
         Long id,
         String nome,
         String shortName,
         Double amount,
         Double maximumPrice,
         Double minimumPrice,
         Double salePrice,
         Double buyPrice,
         String imgUrl,
         String longDescription,
         LocalDate dataDaCotacao,
         Long usuario_id
) {
    public ConversionCreateDTO ( Conversao conversao ){
        this(conversao.getId(), conversao.getNome(), conversao.getShortName(),
                conversao.getAmount(), conversao.getMaximumPrice(), conversao.getMinimumPrice(), conversao.getSalePrice(),
                conversao.getBuyPrice(), conversao.getImgUrl(), conversao.getLongDescription(), conversao.getDataDaCotacao(),
                conversao.getUsuario().getId());
    }
}
