package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.Cotacao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.CotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value="/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;
    
    @GetMapping
    public Cotacao getCotacao() {
        Cotacao cotacao = cotacaoService.getExchangeRate("USD-BRL");
        return cotacao;
    }

}
