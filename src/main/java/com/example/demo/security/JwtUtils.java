package com.example.demo.security;

import com.example.demo.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private final String secretKey = "claveSuperSecreta1234567890abcd1234";// tu clave secreta
    // Convertimos el secreto a un objeto Key
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                //.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .signWith(key)  // Aquí usamos el objeto Key, no el método deprecated
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // Usamos la misma key que para firmar
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
