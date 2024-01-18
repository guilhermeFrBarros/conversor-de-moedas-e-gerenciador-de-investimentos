package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public  ResponseEntity<DetalConversionDTO> create(@RequestBody ConversionCreateDTO conversionDTO) {
        Conversao conversao = conversaoService.create( conversionDTO );
        DetalConversionDTO detalConversionDTO = new DetalConversionDTO( conversao );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand( detalConversionDTO.id() ).toUri();

        return ResponseEntity.created(uri).body( detalConversionDTO );
    }

    @PutMapping
    public ResponseEntity<DetalConversionDTO> uptadte( @RequestBody ConversionUptadeDTO conversionUptadeDTO) {
        Conversao conversao  = conversaoService.atualizar( conversionUptadeDTO );

        return ResponseEntity.ok( new DetalConversionDTO( conversao ) );
    }

    // @GetMapping("/param")
    // public ResponseEntity< ConversaoMinDTO > conversion( @RequestParam ( value = )) {

    // }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar ( @PathVariable Long id ) {
        conversaoService.deletar(id);

        return  ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetalConversionDTO> detailConversion( @PathVariable Long id ) {
       DetalConversionDTO detalConversionDTO = conversaoService.detalhar( id );

       return ResponseEntity.ok( detalConversionDTO );
    }
}
