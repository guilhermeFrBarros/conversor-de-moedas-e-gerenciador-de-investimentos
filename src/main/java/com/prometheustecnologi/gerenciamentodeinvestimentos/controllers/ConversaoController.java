package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.DetalConversionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.ConversaoService;

@RestController
@RequestMapping(value = "/conversao")
public class ConversaoController {
    @Autowired
    private ConversaoService conversaoService;

    @GetMapping
    //@Transactional
    public ResponseEntity< Page<ConversaoMinDTO> > listConversions(
            @PageableDefault( size = 10, sort = {"shortName"}) Pageable paginacao) {
        var listDeConversoe = conversaoService.listConversionsInDTO(paginacao);

        return ResponseEntity.ok( listDeConversoe );
    }




    // @GetMapping("/param")
    // public ResponseEntity< ConversaoMinDTO > conversion( @RequestParam ( value = )) {

    // }

    @GetMapping("/{id}")

    public ResponseEntity<DetalConversionDTO> detailConversion( @PathVariable Long id ) {
       DetalConversionDTO detalConversionDTO = conversaoService.detalhar( id );

       return ResponseEntity.ok( detalConversionDTO );
    }
}
