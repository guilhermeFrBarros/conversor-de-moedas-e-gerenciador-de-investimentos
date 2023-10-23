package com.prometheustecnologi.gerenciamentodeinvestimentos.services;



import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prometheustecnologi.gerenciamentodeinvestimentos.dto.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.ConversaoRepository;

@Service
public class ConversaoService {
    
    @Autowired
    private ConversaoRepository conversaoRepository;

    public List<ConversaoMinDTO>  listConversionsInDTO() {
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


