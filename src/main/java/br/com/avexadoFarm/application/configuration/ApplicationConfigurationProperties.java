package br.com.avexadoFarm.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix="avexado-farm.jwt-token")
public class ApplicationConfigurationProperties {

    private String segredo;
    private Long expiracao;
    private PropiedadeProperties propriedade = new PropiedadeProperties();

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

    public PropiedadeProperties getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(PropiedadeProperties propriedade) {
        this.propriedade = propriedade;
    }

    public static class PropiedadeProperties {
        private String nada;
        private int numero;

        public String getNada() {
            return nada;
        }

        public void setNada(String nada) {
            this.nada = nada;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }
    }
}
