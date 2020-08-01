package br.com.avexadoFarm.infrastructure.security.service;

import br.com.avexadoFarm.infrastructure.security.UserDetail;
import br.com.avexadoFarm.infrastructure.security.util.JWTUtil;
import br.com.avexadoFarm.presentation.dto.usuario.UsuarioAuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationServiceImpl {

    private UsuarioAuthenticationDTO usuarioAuthenticationDTO;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    public String authenticate(UsuarioAuthenticationDTO usuarioAuthenticationDTO) {
        UserDetail userDetail =  null;
        String token = null;

        try {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(usuarioAuthenticationDTO.getLogin(), usuarioAuthenticationDTO.getSenha(), new ArrayList<>());

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            userDetail = userDetailService.loadUserByUsername(usuarioAuthenticationDTO.getLogin());
            token = jwtUtil.generateToken(userDetail);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return token;
    }
}
