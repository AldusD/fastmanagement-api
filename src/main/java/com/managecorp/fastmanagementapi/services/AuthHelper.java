package com.managecorp.fastmanagementapi.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.HashMap;

public class AuthHelper {
    final int DAY_IN_MILLISECONDS = 1000 * 60 * 60 * 24;
    String secret = (!System.getenv("SECRET_KEY").isEmpty()) ? System.getenv("SECRET_KEY") : "placeholder";

    @Autowired
    BCryptPasswordEncoder bcrypt;

    public String encryptPassword (String password) {
        String encryptedPassword = bcrypt.encode((password));
        return encryptedPassword;
    }

    public boolean verifyPassword (String password, String hash) {
        return bcrypt.matches(password, hash);
    }
    public String createToken (long id) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject("" + id)
                .setExpiration(new Date(System.currentTimeMillis() + DAY_IN_MILLISECONDS))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public long validateToken(String token) {
        long id = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()::getSubject;
    }
}
