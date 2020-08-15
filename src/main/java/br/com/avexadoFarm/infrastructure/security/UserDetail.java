package br.com.avexadoFarm.infrastructure.security;

import br.com.avexadoFarm.domain.model.usuario.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserDetail extends User {

    private Usuario usuario;

    public UserDetail(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getLogin(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
