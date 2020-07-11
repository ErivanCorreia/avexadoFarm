package br.com.avexadoFarm.infrastructure.security.service;

import br.com.avexadoFarm.domain.enumeration.Perfil;
import br.com.avexadoFarm.domain.model.Usuario;
import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.repository.UsuarioRepository;
import br.com.avexadoFarm.infrastructure.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDatailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
        if (!usuario.isPresent()) {
            throw new ObjectNotFoundException();
        }

        return new UserDetail(usuario.get(), getAuthorities(usuario.get()));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        usuario.getPerfil().stream().forEach(perfil -> authorities.add(new SimpleGrantedAuthority(perfil.name())));

        return authorities;
    }

}
