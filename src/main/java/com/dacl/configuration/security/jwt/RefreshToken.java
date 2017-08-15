package com.deloitte.ucl.configuration.security.jwt;

import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;

import com.deloitte.ucl.configuration.security.model.Scopes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@SuppressWarnings("unchecked")
public class RefreshToken implements JwtToken {
    private Jws<Claims> claims;

    private RefreshToken(Jws<Claims> claims) {
        this.claims = claims;
    }

    /**
     * Creates and validates Refresh token 
     * 
     * @param token
     * @param signingKey
     * 
     * @throws BadCredentialsException
     * @throws JwtExpiredTokenException
     * 
     * @return
     */
    
    public static RefreshToken create(RawAccessJwtToken token, String signingKey) {
        Jws<Claims> claims = token.parseClaims(signingKey);

        List<String> scopes = claims.getBody().get("scopes", List.class);
        if (scopes == null || scopes.isEmpty()|| !Scopes.REFRESH_TOKEN.authority().equals(scopes.get(0))){ 
            return null;
        }
        return new RefreshToken(claims);
    }
    
    @Override
    public String getToken() {
        return null;
    }

    public Jws<Claims> getClaims() {
        return claims;
    }
    
    public String getJti() {
        return claims.getBody().getId();
    }
    
    public String getSubject() {
        return claims.getBody().getSubject();
    }
}
