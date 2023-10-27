package com.example.ecommerce.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    public static final String SECRET = "E1kY2klrKSWLgJ7J0dVapmScHgSEaTm5E/OuR3xP4ks=";

    public String generateToken(String userName){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String,Object> claims, String userName){
        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10000 * 60 * 30))
                .signWith(getSignKey(), Jwts.SIG.HS256).compact();
    }

    private SecretKey getSignKey(){
        byte[] keybytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keybytes);
    }
}
