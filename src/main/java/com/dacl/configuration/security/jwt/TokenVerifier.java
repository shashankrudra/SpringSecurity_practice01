package com.dacl.configuration.security.jwt;
public interface TokenVerifier {
    public boolean verify(String jti);
}