package br.com.avexadoFarm.infrastructure.service;

import br.com.avexadoFarm.presentation.dto.email.EmailResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(EmailResquestDTO emailResquestDTO) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

            mimeMessageHelper.setSubject(emailResquestDTO.getAssunto());
            mimeMessageHelper.setText(emailResquestDTO.getMensagem(), true);
            mimeMessageHelper.setTo(emailResquestDTO.getDestinatario());

            javaMailSender.send(mimeMessage);
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }
    }


}
