package br.com.avexadoFarm.infrastructure.repository;

import br.com.avexadoFarm.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    public Optional<Usuario> findByLogin(String login);

}
