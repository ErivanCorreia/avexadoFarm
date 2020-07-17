package br.com.avexadoFarm.infrastructure.security.filter;

import br.com.avexadoFarm.infrastructure.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


import java.io.IOException;

public class JWTAuthenticatorFilter implements Filter {

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String header = httpServletRequest.getHeader(jwtUtil.AUTH);
        if (header != null && ) {

        }
    }

}
