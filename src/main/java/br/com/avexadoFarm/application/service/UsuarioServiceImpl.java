package br.com.avexadoFarm.application.service;

import br.com.avexadoFarm.domain.model.usuario.Usuario;
import br.com.avexadoFarm.domain.service.UsuarioService;
import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Usuario buscarPorLogin(String login) {
        Optional<Usuario> usuario = getRepository().findByLogin(login);

        if (!usuario.isPresent()) {
            throw new ObjectNotFoundException();
        }
        return usuario.get();
    }

    @Override
    public Usuario save(Usuario usuario) {
        String senhaEncriptada = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncriptada);

        return super.save(usuario);
    }

    @Override
    protected UsuarioRepository getRepository() {
        return usuarioRepository;
    }
}
