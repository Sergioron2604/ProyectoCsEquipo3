package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.domain.model.EstadoEstudiante;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.model.Universidad;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import com.example.ProyectoCs.domain.repository.HistorialRepository;
import com.example.ProyectoCs.domain.repository.UniversidadRepository;
import com.example.ProyectoCs.domain.repository.EstadoEstudianteRepository;
import org.mindrot.jbcrypt.BCrypt;
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
    private final EstadoEstudianteRepository estadoEstudianteRepository;
    private final UniversidadRepository universidadRepository;



    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository, NotificationService notificationService,UniversidadRepository universidadRepository, EstadoEstudianteRepository estadoEstudianteRepository ) {
        this.estudianteRepository = estudianteRepository;
        this.notificationService = notificationService;
        this.universidadRepository = universidadRepository;
        this.estadoEstudianteRepository=estadoEstudianteRepository;
    }

    public void registrarEstudiante(EstudianteDTO estudianteDTO) throws MessagingException, jakarta.mail.MessagingException {
        Optional<Estudiante> estudianteExistente = Optional.ofNullable(estudianteRepository.findByEmail(estudianteDTO.getEmail()));
        if (estudianteExistente.isPresent()) {
            throw new IllegalStateException("El estudiante ya está registrado");
        }

        if (!esContrasenaValida(estudianteDTO.getContraseña())) {
            throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad");
        }

        EstadoEstudiante estadoEstudiante = estadoEstudianteRepository.findById(1)
                .orElseThrow(() -> new IllegalStateException("Estado de estudiante no encontrado"));

        Universidad universidad = universidadRepository.findById(1)
                .orElseThrow(() -> new IllegalStateException("Universidad no encontrada"));

        String contraseñaCifrada = BCrypt.hashpw(estudianteDTO.getContraseña(), BCrypt.gensalt());

        Estudiante estudiante = convertirDTOaEntidad(estudianteDTO);
        estudiante.setContraseña(contraseñaCifrada);
        estudiante.setEstadoEstudiante(estadoEstudiante);
        estudiante.setUniversidad(universidad);
        estudianteRepository.save(estudiante);
        notificationService.sendNotification(estudianteDTO);
    }

    private boolean esContrasenaValida(String contraseña) {
        if (contraseña == null) {
            return false;
        }
        if (contraseña.length() < 8) {
            return false;
        }
        if (!contraseña.matches(".*\\d.*")) {
            return false;
        }
        if (!contraseña.matches(".*[a-z].*")) {
            return false;
        }
        if (!contraseña.matches(".*[A-Z].*")) {
            return false;
        }
        if (!contraseña.matches(".*[!@#$%^&*()].*")) {
            return false;
        }
        return true;
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
