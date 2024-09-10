package com.corporateclient.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class CCUtils {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public static String extractSubject(String token) {
        System.out.println("Received token Value : "+token);
        String jwtToken = token.substring("Bearer ".length());
        System.out.println("Started execution of extractSubject");
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims.getSubject();
    }
}
