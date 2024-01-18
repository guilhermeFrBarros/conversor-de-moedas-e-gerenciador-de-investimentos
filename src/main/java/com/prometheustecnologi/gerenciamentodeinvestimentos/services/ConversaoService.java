package com.prometheustecnologi.gerenciamentodeinvestimentos.services;



import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.*;
import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Transactional
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


    @Transactional
    public Conversao atualizar(ConversionUptadeDTO conversionUptadeDTO) {
        Conversao conversao = conversaoRepository.getReferenceById(conversionUptadeDTO.id() );
        conversao.setImgUrl( conversionUptadeDTO.imgUrl() );
        conversao.setLongDescription( conversionUptadeDTO.longDescription() );

        return conversao;
    }

    public void deletar(Long id) {
        conversaoRepository.deleteById(id);
    }
}


