package com.prometheustecnologi.gerenciamentodeinvestimentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prometheustecnologi.gerenciamentodeinvestimentos.dto.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.ConversaoRepository;

@Service
public class ConversaoService {
    
    @Autowired
    private ConversaoRepository conversaoRepository;

    public List<ConversaoMinDTO> findAll() {
        List<Conversao> result = conversaoRepository.findAll();
       //List<Conversao>  result = conversaoRepository.findAll()
       //var result
        List<ConversaoMinDTO> dto = converteEmDto(result);
  
        return dto;
    }


    private List<ConversaoMinDTO> converteEmDto(List<Conversao> cDto){
      return cDto.stream().map(x -> new ConversaoMinDTO(x)).toList();
      //  cDto.stream().map(x -> new ConversaoMinDTO(x)).toList();
    }
}


