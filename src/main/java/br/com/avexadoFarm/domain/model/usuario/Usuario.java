package br.com.avexadoFarm.domain.model;

import br.com.avexadoFarm.domain.enumeration.Perfil;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "t_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String senha;

    @NotNull
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "t_perfil_usuario", joinColumns = @JoinColumn(name = "id_usuario"))
    @Column(name = "perfil")
    private Set<Perfil> perfis = new HashSet<>();

    public Usuario() {

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

    public Set<Perfil> getPerfil() {
        return perfis;
    }

    public void setPerfil(Perfil perfil) {
        this.perfis.add(perfil);
    }
}
