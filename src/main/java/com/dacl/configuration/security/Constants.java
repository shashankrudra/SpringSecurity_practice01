package com.deloitte.ucl.configuration.security;

public class Constants {
	public static final String APP_NAME = "UCL_Simple";
	public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
	public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
	public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
	public static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/token";
	public static final String JWT_TOKEN_HEADER_PREFIX = "Bearer ";
}
