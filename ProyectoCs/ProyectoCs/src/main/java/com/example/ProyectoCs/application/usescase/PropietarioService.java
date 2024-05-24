package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.domain.model.EstadoPropietario;
import com.example.ProyectoCs.domain.model.Propietario;
import com.example.ProyectoCs.domain.repository.EstadoPropietarioRepository;
import com.example.ProyectoCs.domain.repository.PropietarioRepository;
import com.example.ProyectoCs.application.usescase.NotificationService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;
    private final EstadoPropietarioRepository estadoPropietarioRepository;
    private final NotificationService notificationService;

    @Autowired
    public PropietarioService(PropietarioRepository propietarioRepository,
                              EstadoPropietarioRepository estadoPropietarioRepository,
                              NotificationService notificationService) {
        this.propietarioRepository = propietarioRepository;
        this.estadoPropietarioRepository = estadoPropietarioRepository;
        this.notificationService = notificationService;
    }

    public void registrarPropietario(PropietarioDTO propietarioDTO) throws MessagingException {
        Optional<Propietario> propietarioExistente = propietarioRepository.findByEmail(propietarioDTO.getEmail());
        if (propietarioExistente.isPresent()) {
            throw new IllegalStateException("El propietario ya está registrado");
        }
        if (!esContrasenaValida(propietarioDTO.getContraseña())) {
            throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad");
        }

        Propietario propietario = convertirDTOaEntidad(propietarioDTO);
        EstadoPropietario estadoPropietario = estadoPropietarioRepository.findById(3)
                .orElseThrow(() -> new IllegalStateException("Estado de propietario no encontrado"));
        propietario.setEstadoPropietario(estadoPropietario);

        if (propietarioDTO.getIdPropietario() != null) {
            propietario.setIdPropietario(Math.toIntExact(propietarioDTO.getIdPropietario()));
        }

        String contraseñaCifrada = BCrypt.hashpw(propietarioDTO.getContraseña(), BCrypt.gensalt());

        propietario.setContraseña(contraseñaCifrada);
        propietarioRepository.save(propietario);
        notificationService.sendNotification(propietarioDTO);
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

    public void eliminarPropietario(String email) throws MessagingException {
        Optional<Propietario> propietarioOptional = propietarioRepository.findByEmail(email);
        Propietario propietario = propietarioOptional.orElseThrow(() -> new IllegalStateException("El propietario no está registrado"));
        propietarioRepository.delete(propietario);
        String mensajeDespedida = "¡Adiós, " + propietario.getNombre() + "! Lamentamos verte ir. ¡Esperamos verte de nuevo pronto!";
        PropietarioDTO propietarioDTO = convertirEntidadADTO(propietario);
        notificationService.sendNotification(propietarioDTO, mensajeDespedida);
    }

    private Propietario convertirDTOaEntidad(PropietarioDTO propietarioDTO) {
        Propietario propietario = new Propietario();
        propietario.setIdPropietario(propietarioDTO.getIdPropietario());
        propietario.setNombre(propietarioDTO.getNombre());
        propietario.setEmail(propietarioDTO.getEmail());
        propietario.setTelefono(propietarioDTO.getTelefono());
        propietario.setContraseña(propietarioDTO.getContraseña());
        return propietario;
    }

    private PropietarioDTO convertirEntidadADTO(Propietario propietario) {
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setIdPropietario(propietario.getIdPropietario());
        propietarioDTO.setNombre(propietario.getNombre());
        propietarioDTO.setEmail(propietario.getEmail());
        propietarioDTO.setTelefono(propietario.getTelefono());
        propietarioDTO.setContraseña(propietario.getContraseña());
        return propietarioDTO;
    }
}
