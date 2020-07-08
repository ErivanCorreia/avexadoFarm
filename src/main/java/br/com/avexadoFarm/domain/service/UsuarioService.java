package br.com.avexadoFarm.domain.service;

import br.com.avexadoFarm.domain.model.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long> {

    public Usuario buscarPorLogin(String login);

}
