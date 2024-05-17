package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.model.Propietario;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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


    public void sendNotification(PropietarioDTO propietarioDTO) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(propietarioDTO.getEmail());
        message.setSubject("Bienvenido a nuestra plataforma");
        message.setText("Hola " + propietarioDTO.getNombre() + ",\n\n¡Bienvenido a nuestro servicio!"+"\\Hemos notado que te has inscrito en nuestra plataforma, por favor para que se pueda seguir"+
        "con el proceso adjunte los siguientes documentos para su inscripción\n"+
        "1) Cedula de indetificación\n"
        +"2) Carta de propiedad \n"+
        "3) Certificado de vivienda ");

        mailSender.send(message);
    }


    public void sendNotification(PropietarioDTO propietarioDTO, String mensaje) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(propietarioDTO.getEmail());
        message.setSubject("Bienvenido a nuestra plataforma");
        message.setText("Hola " + propietarioDTO.getNombre() + ",\n\nAgradecemos por confiar en nosotros, lamentablemente hasta aquí hemos llegado tu usuario a sido revocado.\n Gracias por compartir este tiempo con nosotros" +
                "\n\nSaludos,\nEquipo 3 Construcción de Software , \n\n Allison, Felipe, Sergio");
    }
}
