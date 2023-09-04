package com.prometheustecnologi.gerenciamentodeinvestimentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.Conversao;

public interface ConversaoRepository extends JpaRepository<Conversao, Long> {
    
}