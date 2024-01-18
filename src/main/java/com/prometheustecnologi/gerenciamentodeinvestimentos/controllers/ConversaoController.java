package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.ConversionCreateDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.DetalConversionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.ConversaoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public  ResponseEntity<ConversionCreateDTO> create(@RequestBody ConversionCreateDTO conversionDTO) {
        Conversao conversao = conversaoService.create( conversionDTO );
        conversionDTO = new ConversionCreateDTO( conversao );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand( conversionDTO.id() ).toUri();

        return ResponseEntity.created(uri).body( conversionDTO );
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
