package com.prometheustecnologi.gerenciamentodeinvestimentos.controllers;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.dtos.DadosAutenticacao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.infra.DadosTokenJWT;
import com.prometheustecnologi.gerenciamentodeinvestimentos.infra.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados ){
        System.out.println(dados.email());
        var token = new UsernamePasswordAuthenticationToken( dados.email(),
                dados.senha() ); // retorna o token

        // Por traz  usa o BCrypt para criptografar e comparar com a senha criptografada no BD
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal() );

        return ResponseEntity.ok( new DadosTokenJWT(tokenJWT));
    }
}
