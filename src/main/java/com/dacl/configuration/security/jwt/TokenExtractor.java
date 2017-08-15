package com.dacl.configuration.security.jwt;
public interface TokenExtractor {
    public String extract(String payload);
}