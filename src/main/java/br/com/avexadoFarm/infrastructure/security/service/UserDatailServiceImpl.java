package br.com.avexadoFarm.infrastructure.security.service;

import br.com.avexadoFarm.domain.enumeration.Perfil;
import br.com.avexadoFarm.domain.model.Usuario;
import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.repository.UsuarioRepository;
import br.com.avexadoFarm.infrastructure.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDatailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        // TODO: 07/07/2020 Criar método auxiliar para busca de usuario  
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
        if (!usuario.isPresent()) {
            throw new ObjectNotFoundException();
        }
        // TODO: 07/07/2020 Criar método auxiliar para retornar authorities de usuario 
        usuario.get().getPerfil().stream().forEach(perfil -> authorities.add(new SimpleGrantedAuthority(perfil.name())));
        return new UserDetail(usuario.get(), authorities);
    }
}
