package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.domain.model.Estudiante;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendNotification(EstudianteDTO estudianteDTO) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(estudianteDTO.getEmail());
        helper.setSubject("Bienvenido a la plataforma");
        helper.setText("Hola " + estudianteDTO.getNombre() + ",\n\nTe damos una bienvenida a nuestra plataforma. ¡Estamos encantados de tenerte con nosotros!\n\nSaludos,\nEquipo 3 Construcción de Software , \n\n Allison, Felipe, Sergio");
        mailSender.send(mimeMessage);
    }

    public void sendNotification(Estudiante estudianteDTO, String mensajeDespedida) throws jakarta.mail.MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(estudianteDTO.getEmail());
        helper.setSubject("Despedida de la plataforma");
        helper.setText("Hola " + estudianteDTO.getNombre() + ",\n\nAgradecemos por confiar en nosotros, lamentablemente hasta aquí hemos llegado tu usuario a sido revocado.\n Gracias por compartir este tiempo con nosotros" +
                "\n\nSaludos,\nEquipo 3 Construcción de Software , \n\n Allison, Felipe, Sergio");
        mailSender.send(mimeMessage);
    }
}
