package br.com.avexadoFarm.presentation.dto.usuario;

import br.com.avexadoFarm.domain.model.usuario.Perfil;

import java.util.Set;

public class UsuarioAuthenticationDTO {

    private String login;
    private String senha;

    public UsuarioAuthenticationDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
