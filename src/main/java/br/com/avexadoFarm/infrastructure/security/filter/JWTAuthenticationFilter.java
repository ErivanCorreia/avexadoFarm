package br.com.avexadoFarm.infrastructure.security.filter;

import br.com.avexadoFarm.infrastructure.security.UserDetail;
import br.com.avexadoFarm.infrastructure.security.service.UserDetailServiceImpl;
import br.com.avexadoFarm.infrastructure.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


import java.io.IOException;

public class JWTAuthenticationFilter implements Filter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String token = httpServletRequest.getHeader(jwtUtil.AUTH);
        if (token != null && token.startsWith(jwtUtil.BEARER)) {
            token = token.substring(7);
        }

        String username = jwtUtil.getUsername(token);

        if (username != null && jwtUtil.validateDateExpitation(username)){
            UsernamePasswordAuthenticationToken auth = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(httpServletRequest, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(String username) {
        UserDetail userDetail = userDetailService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
    }

}
