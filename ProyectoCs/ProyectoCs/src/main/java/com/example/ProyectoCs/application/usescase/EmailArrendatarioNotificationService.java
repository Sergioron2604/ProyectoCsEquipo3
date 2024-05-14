package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.PropietarioDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailArrendatarioNotificationService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailArrendatarioNotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(PropietarioDTO propietario) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(propietario.getEmail());
        helper.setSubject("Notificación para arrendatario");
        helper.setText("Hola " + propietario.getNombre() + ",\n\nEste es un ejemplo de notificación para arrendatarios.\n\nSaludos,\nTu aplicación", false);
        javaMailSender.send(message);
    }
}
