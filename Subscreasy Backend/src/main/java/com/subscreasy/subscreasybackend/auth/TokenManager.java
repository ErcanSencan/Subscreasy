package com.subscreasy.subscreasybackend.auth;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.subscreasy.subscreasybackend.constant.JwtConstants;

public class TokenManager {
	
	public String generateToken(String username){
		return JWT.create()
	                .withSubject(username)
	                .withIssuer("ercansencanoglu")
	                .withExpiresAt(new Date(System.currentTimeMillis() + JwtConstants.EXPIRATION_TIME))
	                .sign(HMAC512(JwtConstants.SECRET.getBytes()));
	}
	
	public Boolean tokenValidate(String token){
		if(getUserFromToken(token) != null && isExpired(token)) {
			return true;
		}
		return false;
	}
	
	public String getUserFromToken(String token) {
		return JWT.require(HMAC512(JwtConstants.SECRET.getBytes()))
        .build()
        .verify(token)
        .getSubject();
		
	}
	
	private Boolean isExpired(String token) {
		return JWT.require(HMAC512(JwtConstants.SECRET.getBytes())).build().verify(token).getExpiresAt().after(new Date(System.currentTimeMillis()));
	
	}
	
}
