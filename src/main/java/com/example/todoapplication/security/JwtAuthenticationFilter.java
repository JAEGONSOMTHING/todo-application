package com.example.todoapplication.security;

import com.example.todoapplication.user.UserAccount;
import com.example.todoapplication.user.AccountService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final AccountService accountService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("!!!");

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")){
            String jwt = token.replace("Bearer", "").trim();


            String username = Jwts.parser().setSigningKey("Jaegon")
                    .parseClaimsJws(jwt).getBody()
                    .getSubject();

            UserAccount userDetails = accountService.loadUserByUsername(username);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());


            SecurityContextHolder.getContext().setAuthentication(authentication);


        }

        filterChain.doFilter(request,response);
    }

}
