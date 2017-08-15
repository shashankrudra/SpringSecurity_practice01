package com.deloitte.ucl.configuration.security.jwt;


import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import static com.deloitte.ucl.configuration.security.Constants.*;


@Component
public class JwtHeaderTokenExtractor implements TokenExtractor {

    @Override
    public String extract(String header) {
        if (StringUtils.isBlank(header)) {
            throw new AuthenticationServiceException("Authorization header cannot be blank!");
        }

        if (header.length() < JWT_TOKEN_HEADER_PREFIX.length()) {
            throw new AuthenticationServiceException("Invalid authorization header size.");
        }

        return header.substring(JWT_TOKEN_HEADER_PREFIX.length(), header.length());
    }
}
