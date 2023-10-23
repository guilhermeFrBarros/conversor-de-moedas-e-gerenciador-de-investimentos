package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prometheustecnologi.gerenciamentodeinvestimentos.dto.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.ConversaoService;

@RestController
@RequestMapping(value = "/conversao")
public class ConversaoController {
    @Autowired
    private ConversaoService conversaoService;

    @GetMapping
    public ResponseEntity< List<ConversaoMinDTO> > listConversions() {
        var listDeConversoes = conversaoService.listConversionsInDTO();

        return ResponseEntity.ok( listDeConversoes );
    }


    // @GetMapping("/param")
    // public ResponseEntity< ConversaoMinDTO > conversion( @RequestParam ( value = )) {

    // }

    @GetMapping("/{id}")
    public void detailConversion() {
// futuro
    }
}
