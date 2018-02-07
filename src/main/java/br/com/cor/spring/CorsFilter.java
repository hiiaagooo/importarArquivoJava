package br.com.correios.spring;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "POST, GET,  PUT, DELETE, OPTIONS";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Content-Type, Authorization ";
    public static final String ACCESS_CONTROL_MAX_AGE = "10";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getHeader("Origin") != null) {
            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        }
        response.addHeader("Access-Control-Allow-Methods", ACCESS_CONTROL_ALLOW_METHODS);
        response.addHeader("Access-Control-Allow-Headers", ACCESS_CONTROL_ALLOW_HEADERS);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Expose-Headers", "*");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
