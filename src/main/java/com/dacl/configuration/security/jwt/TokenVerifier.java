package com.deloitte.ucl.configuration.security.jwt;
public interface TokenVerifier {
    public boolean verify(String jti);
}