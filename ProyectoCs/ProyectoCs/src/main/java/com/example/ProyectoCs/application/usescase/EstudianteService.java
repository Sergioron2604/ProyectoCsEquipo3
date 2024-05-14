package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import com.example.ProyectoCs.domain.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final NotificationService notificationService;
    private final HistorialRepository historialRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository, NotificationService notificationService, HistorialRepository historialRepository) {
        this.estudianteRepository = estudianteRepository;
        this.notificationService = notificationService;
        this.historialRepository = historialRepository;
    }

    public void registrarEstudiante(EstudianteDTO estudianteDTO) throws MessagingException, jakarta.mail.MessagingException {
        Optional<Estudiante> estudianteExistente = Optional.ofNullable(estudianteRepository.findByEmail(estudianteDTO.getEmail()));
        if (estudianteExistente.isPresent()) {
            throw new IllegalStateException("El estudiante ya está registrado");
        }



        Estudiante estudiante = convertirDTOaEntidad(estudianteDTO);
        estudianteRepository.save(estudiante);
        notificationService.sendNotification(estudianteDTO);
    }

    public void eliminarEstudiante(String email) throws MessagingException, jakarta.mail.MessagingException {
        Estudiante estudiante = estudianteRepository.findByEmail(email);
        if (estudiante == null) {
            throw new IllegalStateException("El estudiante no está registrado");
        }
        estudianteRepository.delete(estudiante);
        String mensajeDespedida = "¡Adiós, " + estudiante.getNombre() + "! Lamentamos verte ir. ¡Esperamos verte de nuevo pronto!";
        EstudianteDTO estudianteDTO = convertirEntidadADTO(estudiante);
        notificationService.sendNotification(estudiante, mensajeDespedida);
    }



    private Estudiante convertirDTOaEntidad(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setEdad(estudianteDTO.getEdad());
        estudiante.setEmail(estudianteDTO.getEmail());
        estudiante.setTelefono(estudianteDTO.getTelefono());
        return estudiante;
    }
    public EstudianteDTO convertirEntidadADTO(Estudiante estudiante) {
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setEdad(estudiante.getEdad());
        estudianteDTO.setEmail(estudiante.getEmail());
        estudianteDTO.setTelefono(estudiante.getTelefono());
        return estudianteDTO;
    }

}
