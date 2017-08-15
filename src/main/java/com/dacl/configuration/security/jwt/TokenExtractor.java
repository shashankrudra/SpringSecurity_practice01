package com.deloitte.ucl.configuration.security.jwt;
public interface TokenExtractor {
    public String extract(String payload);
}