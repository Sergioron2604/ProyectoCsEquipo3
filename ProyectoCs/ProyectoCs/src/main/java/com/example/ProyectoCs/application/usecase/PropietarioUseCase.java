package com.example.ProyectoCs.application.usecase;

import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.application.service.NotificationService;
import com.example.ProyectoCs.domain.repository.PropietarioRepository;
import com.example.ProyectoCs.infrastructure.gateway.PropietarioGateway;
import com.example.ProyectoCs.domain.model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Optional;

@Component
public class PropietarioUseCase {

    private final PropietarioGateway propietarioGateway;
    private final NotificationService notificationService;
    private final PropietarioRepository propietarioRepository;

    @Autowired
    public PropietarioUseCase(PropietarioGateway propietarioGateway, NotificationService notificationService, PropietarioRepository propietarioRepository) {
        this.propietarioGateway = propietarioGateway;
        this.notificationService = notificationService;
        this.propietarioRepository = propietarioRepository;
    }

    public void registrarPropietario(PropietarioDTO propietarioDTO) throws MessagingException, jakarta.mail.MessagingException {
        Optional<Propietario> propietarioExistente = propietarioGateway.findByEmail(propietarioDTO.getEmail());
        if (propietarioExistente.isPresent()) {
            throw new IllegalStateException("El propietario ya está registrado");
        }
        if (!esContrasenaValida(propietarioDTO.getContraseña())) {
            throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad");
        }

        Propietario propietario = convertirDTOaEntidad(propietarioDTO);
        propietario.setEstadoPropietario(propietarioGateway.findEstadoPropietarioById(3L));

        if (propietarioDTO.getIdPropietario() != null) {
            propietario.setIdPropietario(propietarioDTO.getIdPropietario());
        }

        String contraseñaCifrada = propietarioGateway.hashPassword(propietarioDTO.getContraseña());
        propietario.setContraseña(contraseñaCifrada);

        propietarioGateway.savePropietario(propietario);
        notificationService.sendWelcomeNotification(propietarioDTO);
    }

    public void eliminarPropietario(String email) throws MessagingException, jakarta.mail.MessagingException {
        Optional<Propietario> propietarioOptional = propietarioRepository.findByEmail(email);
        Propietario propietario = propietarioOptional.orElseThrow(() -> new IllegalStateException("El propietario no está registrado"));
        propietarioRepository.delete(propietario);
        PropietarioDTO propietarioDTO = convertirEntidadADTO(propietario);
        notificationService.sendWelcomeNotification(propietarioDTO);
    }

    private boolean esContrasenaValida(String contraseña) {

        return true;
    }

    private Propietario convertirDTOaEntidad(PropietarioDTO propietarioDTO) {
        Propietario propietario = new Propietario();
        propietario.setIdPropietario(propietarioDTO.getIdPropietario());
        propietario.setNombre(propietarioDTO.getNombre());
        propietario.setEmail(propietarioDTO.getEmail());
        propietario.setContraseña(propietarioDTO.getContraseña());
        propietario.setTelefono(propietarioDTO.getTelefono());
        return propietario;

    }

    private PropietarioDTO convertirEntidadADTO(Propietario propietario) {
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setIdPropietario(propietario.getIdPropietario());
        propietarioDTO.setEmail(propietario.getEmail());
        propietarioDTO.setContraseña(propietario.getContraseña());
        return propietarioDTO;
    }
}

