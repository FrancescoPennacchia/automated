package com.example.automated.config.jwt;


public class SecurityConstants {
    public static final String SECRET = "Secret";
    public static final long EXPIRATION_TIME = 900_000; // 15 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
