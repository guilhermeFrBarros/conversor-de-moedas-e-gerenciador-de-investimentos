package com.prometheustecnologi.gerenciamentodeinvestimentos.services;



import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.ConversionCreateDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.DetalConversionDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.ConversaoMinDTO;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.ConversaoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConversaoService {
    
    @Autowired
    private ConversaoRepository conversaoRepository;

    @Autowired
    private UserRepository userRepository;

    public Page<ConversaoMinDTO> listConversionsInDTO(Pageable  pageable) {
        Page<Conversao> result = conversaoRepository.findAll(pageable);
       //List<Conversao>  result = conversaoRepository.findAll()
        //  var result
        Page<ConversaoMinDTO> conversaoMinDTOPage = result.map(ConversaoMinDTO::new);

  
        return conversaoMinDTOPage;
    }

    public Conversao create(ConversionCreateDTO conversionDTO ) {
        var user = userRepository.getReferenceById(conversionDTO.usuario_id());
        Conversao conversao = new Conversao( conversionDTO, user );
        return conversaoRepository.save( conversao );
    }

    @Transactional( readOnly = true)
    public DetalConversionDTO detalhar(Long id ){
        var conversion = conversaoRepository.getReferenceById( id );
        //var conversion = conversaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conversao not found"));
        return new DetalConversionDTO( conversion );
    }



}


