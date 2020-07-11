package br.com.avexadoFarm.application.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
@ConfigurationProperties("avexado-farm")
public class ApplicationConfigurationProperties {

    private JwtToken jwtToken = new JwtToken();

    public JwtToken getJwtToken() {
        return jwtToken;
    }

    public static class JwtToken {
        private String segredo;
        private Long expriracao;

        public String getSegredo() {
            return segredo;
        }

        public void setSegredo(String segredo) {
            this.segredo = segredo;
        }

        public Long getExpriracao() {
            return expriracao;
        }

        public void setExpriracao(Long expriracao) {
            this.expriracao = expriracao;
        }
    }
}
