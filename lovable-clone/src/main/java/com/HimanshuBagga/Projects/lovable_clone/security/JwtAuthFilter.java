package com.HimanshuBagga.Projects.lovable_clone.security;

import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter { // before going to dispatcher servlet or MVC or controllers these filters will interset the request

    private final AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // it mainly does 4 things --read authentication header , --Extract Token , --Validate Token , --continue the request
        log.info("incoming-request: {}", request.getRequestURI());
        final String requestHeaderToken = request.getHeader("Authorization");
        if(requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        // Authorization = "Bearer ""asdefrgthyjuki"
        String JwtToken = requestHeaderToken.split("Bearer ")[1];
        // now checking is the JwtToken is valid or not
        JwtUserPrinciple user = authUtil.verifyAccessToken(requestHeaderToken);
        // inflate security context with the user
        if(user != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user , null, new ArrayList<>()
            )
        }
    }
}
