package com.dacl.configuration.security.jwt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.dacl.configuration.security.model.JwtToken;
import com.dacl.configuration.security.model.Scopes;
import com.dacl.configuration.security.model.CUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
@PropertySource({ "classpath:jwt/jwt-security.properties" })
public class JwtTokenFactory {
	
	@SuppressWarnings("unused")
	@Autowired
	private Environment env;

	private final JwtSettings settings;

    @Autowired
    public JwtTokenFactory(JwtSettings settings) {
        this.settings = settings;
    }

    /**
     * Factory method for issuing new JWT Tokens.
     * 
     * @param username
     * @param roles
     * @return
     */
    public AccessJwtToken createAccessJwtToken(CUser userContext) {
        if (StringUtils.isBlank(userContext.getUsername())) 
            throw new IllegalArgumentException("Cannot create JWT Token without username");

        if (userContext.getAuthorities() == null || userContext.getAuthorities().isEmpty()) 
            throw new IllegalArgumentException("User doesn't have any privileges");

        Claims claims = Jwts.claims().setSubject(userContext.getUsername());
        List<String> authorities = new ArrayList<>();
        for(GrantedAuthority ga: userContext.getAuthorities()){
        	authorities.add(ga.getAuthority());
        }
        
        claims.put("scopes",authorities);
        //claims.put("expWarnTime",env.getProperty("expirationWarningTime"));
        claims.put("expWarnTime", settings.getTokenExpirationTime());
        
        DateTime currentTime = new DateTime();

        String accesstoken = Jwts.builder()
          .setClaims(claims)
          //.setIssuer(env.getProperty("tokenIssuer"))
          .setIssuer(settings.getTokenIssuer())
          .setIssuedAt(currentTime.toDate())
          /*.setExpiration(currentTime.plusMinutes(Integer.parseInt(env.getProperty("tokenExpirationTime"))).toDate())
          .signWith(SignatureAlgorithm.HS512, env.getProperty("tokenSigningKey"))*/
          .setExpiration(currentTime.plusMinutes(settings.getTokenExpirationTime()).toDate())
          .signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
        .compact();

        return new AccessJwtToken(accesstoken, claims);
    }

    public JwtToken createRefreshToken(CUser userContext) {
        if (StringUtils.isBlank(userContext.getUsername())) {
            throw new IllegalArgumentException("Cannot create JWT Token without username");
        }

        DateTime currentTime = new DateTime();

        Claims claims = Jwts.claims().setSubject(userContext.getUsername());
        claims.put("scopes", Arrays.asList(Scopes.REFRESH_TOKEN.authority()));

        String token = Jwts.builder()
          .setClaims(claims)
          //.setIssuer(env.getProperty("tokenIssuer"))
          .setIssuer(settings.getTokenIssuer())
          .setId(UUID.randomUUID().toString())
          .setIssuedAt(currentTime.toDate())
          /*.setExpiration(currentTime.plusMinutes(Integer.parseInt(env.getProperty("refreshTokenExpTime"))).toDate())
          .signWith(SignatureAlgorithm.HS512, env.getProperty("tokenSigningKey"))*/
          .setExpiration(currentTime.plusMinutes(settings.getRefreshTokenExpTime()).toDate())
          .signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey())
        .compact();

        return new AccessJwtToken(token, claims);
    }
}
