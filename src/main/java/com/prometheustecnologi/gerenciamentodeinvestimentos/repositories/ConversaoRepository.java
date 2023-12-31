package com.prometheustecnologi.gerenciamentodeinvestimentos.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.Conversao;

public interface ConversaoRepository extends JpaRepository<Conversao, Long> {
    Page<Conversao> findAll(Pageable paginacao);
}
