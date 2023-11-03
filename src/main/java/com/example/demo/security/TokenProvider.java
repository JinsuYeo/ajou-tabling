//package com.example.demo.security;
//
//import com.example.demo.domain.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//@Slf4j
//@Service
//public class TokenProvider {
//
//    private static final String SECRET_KEY = "FlRpX30pMqDbiAkmlfArbrmVkDD4RqISskGZmBFax5oGVxzXXWUzTR5JyskiHMIV9M1Oicegkpi46AdvrcX1E6CmTUBc6IFbTPiD";
//
//    public String create(User user) {
//
//        Date expiryDate = Date.from(
//                Instant.now().plus(1, ChronoUnit.DAYS)
//        );
//
//        return Jwts.builder()
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .setSubject(String.valueOf(user.getId()))
//                .setIssuer("demo app")
//                .setIssuedAt(new Date())
//                .setExpiration(expiryDate)
//                .compact();
//    }
//
//    public String validateAndGetUserId(String token) {
//
//        Claims claims = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//}