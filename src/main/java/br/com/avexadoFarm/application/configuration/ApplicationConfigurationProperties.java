package br.com.avexadoFarm.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix="avexado-farm.jwt-token")
public class ApplicationConfigurationProperties {

    private String segredo;
    private Long expiracao;

    public String getSegredo() {
        return segredo;
    }

    public void setSegredo(String segredo) {
        this.segredo = segredo;
    }

    public Long getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(Long expiracao) {
        this.expiracao = expiracao;
    }

}
