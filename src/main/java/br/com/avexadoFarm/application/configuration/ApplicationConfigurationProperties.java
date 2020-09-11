package br.com.avexadoFarm.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("avexado-farm")
public class ApplicationConfigurationProperties {

    private Token token = new Token();
    private String remetente;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public static class Token {
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

}
