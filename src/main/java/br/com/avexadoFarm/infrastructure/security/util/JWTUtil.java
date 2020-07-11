package br.com.avexadoFarm.infrastructure.security.util;


import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties;
import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties.JwtToken;
import br.com.avexadoFarm.infrastructure.security.UserDetail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private ApplicationConfigurationProperties applicationConfigurationProperties;

    public String generateToken(UserDetail userDetail){

        return Jwts.builder()
                .setSubject(userDetail.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + getJwtToken().getExpriracao()))
                .signWith(SignatureAlgorithm.HS512, getJwtToken().getSegredo())
                .compact();
    }

    public JwtToken getJwtToken() {
        return applicationConfigurationProperties.getJwtToken();
    }

}
