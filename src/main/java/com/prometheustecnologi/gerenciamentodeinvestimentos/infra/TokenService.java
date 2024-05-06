package com.prometheustecnologi.gerenciamentodeinvestimentos.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(User user) {
        try {
            // algorithm -> Serve para assinar o JWT assim garantindo segurança
            Algorithm algorithm = Algorithm.HMAC256("123456789");
            //criando e assinando token
            String token = JWT.create()
                    // passando informanções para token
                            .withIssuer("prometheustecnologi.gerenciamentodeinvestimentos API")
                            .withSubject(user.getEmail())
                            .withExpiresAt(dataExpericao())
                            .sign(algorithm);// assinando
            return token;
        }
        catch (JWTCreationException exception){
            throw new RuntimeException("Error ao gerar token JWT", exception);
        }
    }

    private Instant dataExpericao() {
        return LocalDateTime.now().plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
