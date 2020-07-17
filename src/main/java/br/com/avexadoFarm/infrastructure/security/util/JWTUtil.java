package br.com.avexadoFarm.infrastructure.security.util;


import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties;
import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties.JwtToken;
import br.com.avexadoFarm.infrastructure.security.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    public static final String AUTH = "Authorization";
    public static final String BEARER = "Bearer ";

    private ApplicationConfigurationProperties applicationConfigurationProperties;

    public String generateToken(UserDetail userDetail){

        return Jwts.builder()
                .setSubject(userDetail.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + getJwtToken().getExpriracao()))
                .signWith(SignatureAlgorithm.HS512, getJwtToken().getSegredo())
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
        try {
            return Jwts.parser().setSigningKey(getJwtToken().getSegredo().getBytes()).parseClaimsJws(token).getBody();
        }
        catch (Exception e) {
            return null;
        }
    }

    public JwtToken getJwtToken() {
        return applicationConfigurationProperties.getJwtToken();
    }

}
