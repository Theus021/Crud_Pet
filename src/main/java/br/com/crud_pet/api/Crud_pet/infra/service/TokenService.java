package br.com.crud_pet.api.Crud_pet.infra.service;

import br.com.crud_pet.api.Crud_pet.domain.user.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("api.security.token.secret")
    private String secret;
    public String generationToken(Users user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("crud_pet")
                    .withSubject(user.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        return token;
        } catch(JWTCreationException e){
            throw new RuntimeException("Error while generating token", e);
        }
    }

    public String validationToken(String token){
        try {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer("crud_pet")
                .build()
                .verify(token)
                .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Error while verify token", e);
        }
    }
    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
