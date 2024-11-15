package com.hypermedicus.common.utils;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.UUID;

public class JWTUtil {
    private static String key = "30overkeys30overkeys30overkeys30overkeys";

    public static SecretKey getKey() {
        SecretKey key = null;
        try{
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return key;
    }

    public static String generateToken(UUID token_uuid, int min) {
        String jwtStr = Jwts.builder()
        .header()
            .add("typ", "JWT")
            .and()
        .claim("uuid", token_uuid.toString())
        .issuedAt(Date.from(ZonedDateTime.now().toInstant()))
        .expiration(Date.from(ZonedDateTime.now().plusMinutes(min).toInstant()))
        .signWith(getKey())
        .compact();

        return jwtStr;
    }
}
