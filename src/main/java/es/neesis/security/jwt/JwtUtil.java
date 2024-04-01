package es.neesis.security.jwt;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    @Value("${spring.security.jwt.key}")
    private String jwtKey;
    @Value("${spring.security.jwt.token.validity}")
    private long jwtTokenValidity;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +jwtTokenValidity))
                .signWith(getSignatureKey())
                .compact();
    }

    public Boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignatureKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = getAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Claims getAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignatureKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public SecretKey getSignatureKey() {
        byte[] key = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(key);
    }
}
