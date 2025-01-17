package com.manager.barbeariamanagerbl.autenticacao.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.manager.barbeariamanagerbl.usuarios.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${token.secret}")
    private String tokenSecret;

    public String gerarToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            String token = JWT.create().withIssuer("barbeariamanager")
                    .withSubject(user.getEmail())
                    .withExpiresAt(Date.from(this.tempoTokenExpiracao()))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro de autenticação");
        }

    }

    private String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            return JWT.require(algorithm)
                    .withIssuer("barbeariamanager")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (RuntimeException e) {
            throw new RuntimeException("Token invalido");
        }
    }

    private Instant tempoTokenExpiracao(){
        return Instant.now().plus(2, ChronoUnit.HOURS);
    }


}
