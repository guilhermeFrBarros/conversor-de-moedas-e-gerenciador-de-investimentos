package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import jakarta.persistence.Column;



import java.time.LocalDate;

public record DetalConversionDTO(Long id,
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
                                 Long userId) {
    public DetalConversionDTO( Conversao conversao ){
        this(conversao.getId(), conversao.getNome(), conversao.getShortName(), conversao.getAmount(),
                conversao.getMaximumPrice(), conversao.getMinimumPrice(), conversao.getSalePrice(),
                conversao.getBuyPrice(), conversao.getImgUrl(), conversao.getLongDescription(),
                conversao.getDataDaCotacao(), conversao.getUsuario().getId());
    }
}
