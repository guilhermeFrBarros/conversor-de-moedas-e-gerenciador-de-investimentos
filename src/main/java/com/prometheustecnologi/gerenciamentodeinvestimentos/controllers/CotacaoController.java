package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.cotacao.Cotacao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.cotacao.DTODadosCotacaoRetorno;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.CotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;
    
    @GetMapping("/{shortName}") 
    public ResponseEntity< DTODadosCotacaoRetorno > getCotacao(@PathVariable String shortName ) { //"USD-BRL"
        var cotacao = cotacaoService.getExchangeRate( shortName );

        var DTOCotacao = new DTODadosCotacaoRetorno( cotacao );


        return ResponseEntity.ok( DTOCotacao );
    }

}
