package br.com.avexadoFarm.infrastructure.factory;

import br.com.avexadoFarm.domain.model.usuario.Usuario;
import br.com.avexadoFarm.presentation.dto.email.EmailResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmailFactory {

    private final String TAMPLATE_CRIACAO_USUARIO = "email/usuario-criacao";
    private final String ASSUNTO_CRIACAO_USUARIO = "Criação de Usuário";

    @Autowired
    private TemplateEngine templateEngine;

    public EmailResquestDTO createRegistroUsuario(Usuario usuario) {
        Map<String, Object> data =  new HashMap<>();
        data.put("usuario", usuario);

        return new EmailResquestDTO(ASSUNTO_CRIACAO_USUARIO, createMenssagem(TAMPLATE_CRIACAO_USUARIO, data), usuario.getEmail());
    }

    private String createMenssagem(String tamplate_criacao_usuario, Map<String, Object> data) {
        Context context = new Context();
        data.entrySet().forEach(d -> context.setVariable(d.getKey(), d.getValue()));

        return templateEngine.process(tamplate_criacao_usuario, context);
    }

}
