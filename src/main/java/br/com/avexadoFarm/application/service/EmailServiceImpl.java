package br.com.avexadoFarm.application.service;

import br.com.avexadoFarm.application.configuration.ApplicationConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ApplicationConfigurationProperties properties;

    public void sendSimpleMessage(String destinatario, String assunto, String mensagem) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(assunto);
        message.setText(mensagem);
        message.setTo(destinatario);

        javaMailSender.send(message);
    }


}
