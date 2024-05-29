package com.example.ProyectoCs.application.service;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.application.dto.ReservaDTO;
import com.example.ProyectoCs.infrastructure.gateway.EmailSenderGateway;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class NotificationService {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public NotificationService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    public void sendWelcomeNotification(EstudianteDTO estudianteDTO) throws MessagingException, jakarta.mail.MessagingException {
        String subject = "Bienvenido a la plataforma";
        String text = "Hola " + estudianteDTO.getNombre() + "\n\n"+"Te damos una bienvenida a nuestra plataforma. ¡Estamos encantados de tenerte con nosotros!"+"\n\n"+"Saludos,\nEquipo 3 Construcción de Software , "+"\n\n"+" Allison, Felipe, Sergio";
        emailSenderGateway.sendEmail(estudianteDTO.getEmail(), subject, text);
    }

    public void sendFarewellNotification(EstudianteDTO estudianteDTO) throws MessagingException, jakarta.mail.MessagingException {
        String subject = "Despedida de la plataforma";
        String text = "Hola " + estudianteDTO.getNombre() + ",\n\nAgradecemos por confiar en nosotros, lamentablemente hasta aquí hemos llegado tu usuario ha sido revocado.\n Gracias por compartir este tiempo con nosotros" +
                "\n\nSaludos,\nEquipo 3 Construcción de Software , \n\n Allison, Felipe, Sergio";
        emailSenderGateway.sendEmail(estudianteDTO.getEmail(), subject, text);
    }

    public void sendWelcomeNotification(PropietarioDTO propietarioDTO) throws MessagingException, jakarta.mail.MessagingException {
        String subject = "Bienvenido a nuestra plataforma";
        String text = "Hola " + propietarioDTO.getNombre() + ",\n\n¡Bienvenido a nuestro servicio!"+"\nHemos notado que te has inscrito en nuestra plataforma, por favor para que se pueda seguir con el proceso adjunte los siguientes documentos para su inscripción\n"+
                "1) Cedula de indetificación\n"
                +"2) Carta de propiedad \n"+
                "3) Certificado de vivienda ";
        emailSenderGateway.sendEmail(propietarioDTO.getEmail(), subject, text);
    }

    public void sendFarewellNotification(PropietarioDTO propietarioDTO) throws MessagingException, jakarta.mail.MessagingException {
        String subject = "Despedida de la plataforma";
        String text = "Hola " + propietarioDTO.getNombre() + ",\n\nAgradecemos por confiar en nosotros, lamentablemente hasta aquí hemos llegado tu usuario ha sido revocado.\n Gracias por compartir este tiempo con nosotros" +
                "\n\nSaludos,\nEquipo 3 Construcción de Software , \n\n Allison, Felipe, Sergio";
        emailSenderGateway.sendEmail(propietarioDTO.getEmail(), subject, text);
    }

    public void sendNewRoomNotification(EstudianteDTO estudianteDTO) throws MessagingException, jakarta.mail.MessagingException {
        String subject = "Nueva Habitación Disponible";
        String text = "Hola " + estudianteDTO.getNombre() + ",\n\nTe queremos informar sobre una habitación disponible. Mira en la aplicación para saber si te interesa.\n\nAtentamente\nGrupo 3 Construcción de software";
        emailSenderGateway.sendEmail(estudianteDTO.getEmail(), subject, text);
    }


    public void sendNewReserve(ReservaDTO reservaDTO) throws MessagingException, jakarta.mail.MessagingException {
        String subject = "Agendamiento de reserva ";
        String text = "Hola " + reservaDTO.getEmailEstudiante() + ",\n\nTe queremos informar sobre la reserva que acabas de realizar  .\n\nAtentamente\nGrupo 3 Construcción de software";
        emailSenderGateway.sendEmail(reservaDTO.getEmailEstudiante(), subject, text);
    }
}
