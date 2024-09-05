package com.yun.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {
    private static String secretString = "HR+rdocYWaGhs0a+lPzFDHc/uwqrf24LUZ7ie8rX9ko=";
    private long expiration = 30 * 60 * 60;
    private static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

    @Test
    public void genKey() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 6);
        map.put("name", "yun");
        String compact = Jwts.builder().setClaims(map).setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(key).compact();
        System.out.println(compact);
    }

    @Test
    public void genS() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(encode);
    }

    @Test
    public void verify() {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoieXVuIiwiaWQiOjYsImV4cCI6MTcyNTE1Njc3MX0.HcL8kJ0jXTfZzUfIu7zNpjt2x9OF79oLSotoYGRUYDo";
        JwtParser build=Jwts.parserBuilder().setSigningKey(key).build();
        Claims body=build.parseClaimsJws(token).getBody();

    }

}