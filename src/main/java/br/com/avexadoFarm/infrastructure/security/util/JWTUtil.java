package br.com.avexadoFarm.infrastructure.security.util;


import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties;
import br.com.avexadoFarm.infrastructure.security.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    public static final String AUTH = "Authorization";
    public static final String BEARER = "Bearer ";

    @Autowired
    private ApplicationConfigurationProperties properties;

    public String generateToken(UserDetail userDetail){

        return Jwts.builder()
                .setSubject(userDetail.getUsername())
                .setClaims(Jwts.claims().setSubject(userDetail.getUsername()))
                .setExpiration(new Date(System.currentTimeMillis() + properties.getToken().getExpiracao()))
                .signWith(SignatureAlgorithm.HS512, properties.getToken().getSegredo())
                .compact();
    }

    public String getUsername(String token) {
        String username;
        try {
            Claims claims = getClaims(token);
            username = claims.getSubject();
        }
        catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Boolean validateDateExpitation(String token) {
        Claims claims = getClaims(token);
        Date expirationDate = claims.getExpiration();
        Date newExpiration = new Date(System.currentTimeMillis());

        if (expirationDate != null && newExpiration.before(expirationDate)) {
            return true;
        }
        return false;
    }

    private Claims getClaims(String token) {
        Claims claims;
        try {
            claims =  Jwts.parser().setSigningKey(properties.getToken().getSegredo()).parseClaimsJws(token).getBody();
        }
        catch (Exception e) {
            claims = null;
        }
        return claims;
    }


}
