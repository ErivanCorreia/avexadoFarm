package br.com.avexadoFarm.presentation.dto.usuario;

import br.com.avexadoFarm.domain.model.usuario.Perfil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UsuarioResponseDTO {

    private Long id;
    private String login;
    private String email;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
