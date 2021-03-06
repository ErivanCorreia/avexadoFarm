package br.com.avexadoFarm.presentation.dto.usuario;

import br.com.avexadoFarm.domain.model.usuario.Perfil;

import java.util.Set;

public class UsuarioRequestDTO {

    private String login;
    private String senha;
    private String email;
    private Set<Perfil> perfis;

    public UsuarioRequestDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}
