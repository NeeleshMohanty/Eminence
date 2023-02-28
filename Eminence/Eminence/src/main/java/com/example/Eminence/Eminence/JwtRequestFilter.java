package com.example.Eminence.Eminence;

import com.example.Eminence.Eminence.Config.JwtTokenProvider;
import com.example.Eminence.Eminence.Service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Get the JWT token from the Authorization header
        String jwtToken = jwtTokenProvider.resolveToken(request);

        if (jwtToken != null && jwtTokenProvider.validateToken(jwtToken)) {
            // Extract the username from the JWT token
            String username = jwtTokenProvider.getUsernameFromToken(jwtToken);

            // Load the user details from the database based on the username
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Create an authentication token for the user
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            // Set the authentication context for the current thread
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
