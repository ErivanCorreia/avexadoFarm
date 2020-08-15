package br.com.avexadoFarm.infrastructure.security.filter;

import br.com.avexadoFarm.infrastructure.security.UserDetail;
import br.com.avexadoFarm.infrastructure.security.service.UserDetailServiceImpl;
import br.com.avexadoFarm.infrastructure.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailServiceImpl userDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(jwtUtil.AUTH);
        if (token != null && token.startsWith(jwtUtil.BEARER)) {
            token = token.substring(7);
        }

        String username = jwtUtil.getUsername(token);

        if (username != null && jwtUtil.validateDateExpitation(token)){
            UsernamePasswordAuthenticationToken auth = getAuthentication(username);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String username) {
        UserDetail userDetail = userDetailService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
    }

}
