package br.com.avexadoFarm.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(String destinatario, String assunto, String mensagem) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("erivann47@gmail.com");
        message.setSubject(assunto);
        message.setText(mensagem);
        message.setTo(destinatario);

        javaMailSender.send(message);
    }


}
