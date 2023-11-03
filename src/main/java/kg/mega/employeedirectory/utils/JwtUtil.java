package kg.mega.employeedirectory.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import kg.mega.employeedirectory.models.dtos.AuthResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    @Value("${jwt.lifetime}")
    private Duration lifetime;

    SecretKey key = Jwts.SIG.HS256.key().build();
    public String generateToken(UserDetails user){
        Date issuedDate = new Date();
        Date expirationDate = new Date(issuedDate.getTime()+lifetime.toMillis());
        return Jwts.builder()
                .claim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .subject(user.getUsername())
                .issuedAt(issuedDate)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }


    private Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public AuthResponseDto parseToken(String token){
        AuthResponseDto responseDto = new AuthResponseDto();
        Claims claims = getClaims(token);
        responseDto.setToken(token);
        responseDto.setUsername(claims.getSubject());
        responseDto.setActiveTill(claims.getExpiration());
        return responseDto;
    }


    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public List<String> getRoles(String token) {
        return getClaims(token).get("roles", List.class);
    }
}