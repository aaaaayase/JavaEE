package com.yun.blog.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtils {
    private static long expiration = 30 * 60 * 60;
    private static String secretString = "HR+rdocYWaGhs0a+lPzFDHc/uwqrf24LUZ7ie8rX9ko=";
    private static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

    public static String genJwt(Map<String, Object> claims) {
        String compact = Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(key).compact();
        return compact;
    }

    public static Claims verify(String token) {
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = null;
        try {
            claims = build.parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("token过期，校验失败，token:" + token);
        } catch (Exception e) {
            log.error("token校验失败，token:" + token);
        }

        return claims;
    }

    public static Integer getJwtUserId(String token) {
        Claims claims = verify(token);
        Assert.notNull(claims, "claims为空");
        Integer userId = (Integer) claims.get("id");
        return userId;
    }
}
