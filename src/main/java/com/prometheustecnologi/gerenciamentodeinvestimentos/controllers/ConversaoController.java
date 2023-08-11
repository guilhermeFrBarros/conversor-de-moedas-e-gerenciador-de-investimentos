package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prometheustecnologi.gerenciamentodeinvestimentos.dto.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.services.ConversaoService;

@RestController
@RequestMapping(value = "/conversoes")
public class ConversaoController {
    @Autowired
    private ConversaoService conversaoService;

    @GetMapping
    public List<ConversaoMinDTO> findAll() {
        var result = conversaoService.findAll();
        return result;
    }
}
