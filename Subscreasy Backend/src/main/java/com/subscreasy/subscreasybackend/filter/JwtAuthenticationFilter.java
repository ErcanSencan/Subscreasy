package com.subscreasy.subscreasybackend.filter;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.subscreasy.subscreasybackend.auth.TokenManager;
import com.subscreasy.subscreasybackend.auth.UserPrincipal;
import com.subscreasy.subscreasybackend.constant.JwtConstants;
import com.subscreasy.subscreasybackend.dto.LoginModel;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
    private AuthenticationManager authenticationManager;
    private TokenManager tokenManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.tokenManager = new TokenManager();
        this.setFilterProcessesUrl("/login");
    }

    /* Trigger when we issue POST request to /login
    We also need to pass in {"username":"ercan", "password":"ercan"} in the request body
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // Grab credentials and map them to login viewmodel
    	LoginModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUserName(),
                credentials.getPassword(),
                new ArrayList<>());

        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        // Create JWT Token
        String token = tokenManager.generateToken(principal.getUsername());
        
        // Add token in response
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader(JwtConstants.HEADER_STRING, JwtConstants.TOKEN_PREFIX +  token);
        String authrotie = authResult.getAuthorities().toArray()[0].toString();
        response.addHeader("Role", authrotie);
    }
    
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,HttpServletResponse response, AuthenticationException failed)
    {
    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
   
}

