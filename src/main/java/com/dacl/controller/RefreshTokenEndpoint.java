package com.deloitte.ucl.controller;

import static com.deloitte.ucl.configuration.security.Constants.JWT_TOKEN_HEADER_PARAM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ucl.configuration.security.jwt.JwtSettings;
import com.deloitte.ucl.configuration.security.jwt.JwtTokenFactory;
import com.deloitte.ucl.configuration.security.jwt.RawAccessJwtToken;
import com.deloitte.ucl.configuration.security.jwt.RefreshToken;
import com.deloitte.ucl.configuration.security.jwt.TokenExtractor;
import com.deloitte.ucl.configuration.security.jwt.TokenVerifier;
import com.deloitte.ucl.configuration.security.model.JwtToken;
import com.deloitte.ucl.configuration.security.model.UCLUser;
import com.deloitte.ucl.exception.InvalidJwtTokenException;


@RestController@RequestMapping(value="/api/auth")
public class RefreshTokenEndpoint {
    @Autowired private JwtTokenFactory tokenFactory;
    @Autowired private JwtSettings jwtSettings;
    @Autowired private Environment env;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;
    
    @RequestMapping(value="/token", method=RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    	String tokenPayload = tokenExtractor.extract(request.getHeader(JWT_TOKEN_HEADER_PARAM));
        
        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        //RefreshToken refreshToken = RefreshToken.create(rawToken, env.getProperty("tokenSigningKey"));
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey());
        		
        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtTokenException();
        }
        
        String subject = refreshToken.getSubject();        
        UCLUser user = (UCLUser) userDetailsService.loadUserByUsername(subject);
        return tokenFactory.createAccessJwtToken(user);
    }
}