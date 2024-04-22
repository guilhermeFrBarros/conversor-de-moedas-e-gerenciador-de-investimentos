package com.prometheustecnologi.gerenciamentodeinvestimentos.services;

import com.prometheustecnologi.gerenciamentodeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Quando eu implemento esta inteface eu falo para o spring que vou chamar essa classe e o metodo loadUse... toda vez que faze autenticação
@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var usuario = repository.findByEmail(email);

//        if (usuario == null) {
//            System.out.println("passou aqui 1");
//            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
//        }
        System.out.println("passou aqui 2 ");
        return usuario;
    }
}
