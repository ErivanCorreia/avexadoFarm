package br.com.avexadoFarm.application.service;

import br.com.avexadoFarm.domain.model.Usuario;
import br.com.avexadoFarm.domain.service.UsuarioService;
import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarPorLogin(String login) {
        Optional<Usuario> usuario = getRepository().findByLogin(login);

        if (!usuario.isPresent()) {
            throw new ObjectNotFoundException();
        }
        return usuario.get();
    }

    @Override
    protected UsuarioRepository getRepository() {
        return usuarioRepository;
    }
}
