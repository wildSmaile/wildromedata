package com.templateproject.api.filter;
import org.springframework.stereotype.Component;
import com.templateproject.api.service.*;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;

import java.io.IOException;

@Component
public class AuthFilter implements Filter {
    
    private final AuthService authService;
    
    public AuthFilter(AuthService authService) {
        this.authService = authService;
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;
        
        // Check for OPTIONS request  pour corriger l erreur 
        if (request.getMethod().equals("OPTIONS")) {
            chain.doFilter(request, response);
            return;
        }
        
        var path = request.getServletPath();
        if (!path.equals("/auth/register2") && !path.equals("/auth/login") /**&& !path.equals("/auth/info" )*/) {
            var token = request.getHeader("x-token");
            Integer playerID = authService.findPlayerIdByToken(token);
            if (playerID == null) {
                response.setHeader("Content-type", "application/json");
                response.setStatus(401);
                response.getWriter().println("{" +
                        "\"message\" : \"Invalid Token\"" +
                        "}");
                return;
            }
            request.setAttribute("playerID", playerID);
        }
        chain.doFilter(request, response);
    }
}