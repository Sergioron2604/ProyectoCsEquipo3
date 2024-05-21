package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.application.dto.PreferenciaEstudianteDTO;
import com.example.ProyectoCs.domain.model.Alojamiento;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.repository.AlojamientoRepository;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlojamientoService {

    private final AlojamientoRepository alojamientoRepository;
    private final EstudianteRepository estudianteRepository;
    private final NotificationService notificationService;

    @Autowired
    public AlojamientoService(AlojamientoRepository alojamientoRepository,
                              EstudianteRepository estudianteRepository,
                              NotificationService notificationService) {
        this.alojamientoRepository = alojamientoRepository;
        this.estudianteRepository = estudianteRepository;
        this.notificationService = notificationService;
    }

    public List<AlojamientoDTO> filtrarAlojamientos(double precioMin, double precioMax, String ciudad, boolean tieneLavanderia, boolean tieneRoomie, boolean tieneParqueaderoBicicleta) {
        List<Alojamiento> alojamientos = alojamientoRepository.findAll();
        return alojamientos.stream()
                .filter(a -> a.getPrecio() >= precioMin && a.getPrecio() <= precioMax)
                .filter(a -> a.getCiudad().equalsIgnoreCase(ciudad))
                .filter(a -> a.isTieneLavanderia() == tieneLavanderia)
                .filter(a -> a.isTieneRoomie() == tieneRoomie)
                .filter(a -> a.isTieneParqueaderoBicicleta() == tieneParqueaderoBicicleta)
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    private AlojamientoDTO convertirEntidadADTO(Alojamiento alojamiento) {
        AlojamientoDTO dto = new AlojamientoDTO();
        dto.setIdAlojamiento(alojamiento.getIdAlojamiento());
        dto.setNombreAlojamiento(alojamiento.getNombreAlojamiento());
        dto.setDescripcion(alojamiento.getDescripcion());
        dto.setDireccion(alojamiento.getDireccion());
        dto.setCiudad(alojamiento.getCiudad());
        dto.setPrecio(alojamiento.getPrecio());
        dto.setTieneLavanderia(alojamiento.isTieneLavanderia());
        dto.setTieneRoomie(alojamiento.isTieneRoomie());
        dto.setTieneParqueaderoBicicleta(alojamiento.isTieneParqueaderoBicicleta());
        return dto;
    }

    public void crearNuevaHabitacion(AlojamientoDTO alojamientoDTO) throws MessagingException, jakarta.mail.MessagingException {
        Alojamiento alojamiento = convertirDTOaEntidad(alojamientoDTO);
        Alojamiento nuevaHabitacion = alojamientoRepository.save(alojamiento);

        List<Estudiante> estudiantes = obtenerTodosLosEstudiantes();
        String mensaje = "¡Hola estudiantes! Se ha creado una nueva habitación en nuestra plataforma.";
        for (Estudiante estudiante : estudiantes) {
            notificationService.sendNotificationNew(estudiante, mensaje);
        }
    }
    private List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public List<AlojamientoDTO> buscarAlojamientos(PreferenciaEstudianteDTO preferencias) {
        List<Alojamiento> alojamientos = alojamientoRepository.findAll();
        return alojamientos.stream()
                .filter(a -> a.getPrecio() <= preferencias.getPresupuestoMaximo())
                .filter(a -> a.isTieneLavanderia() == preferencias.isDeseaLavanderia())
                .filter(a -> a.isTieneRoomie() == preferencias.isDeseaRoomie())
                .filter(a -> a.isTieneParqueaderoBicicleta() == preferencias.isNecesitaParqueaderoBicicleta())
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    private Alojamiento convertirDTOaEntidad(AlojamientoDTO alojamientoDTO) {
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setIdAlojamiento(alojamientoDTO.getIdAlojamiento());
        alojamiento.setNombreAlojamiento(alojamientoDTO.getNombreAlojamiento());
        alojamiento.setDescripcion(alojamientoDTO.getDescripcion());
        alojamiento.setDireccion(alojamientoDTO.getDireccion());
        alojamiento.setCiudad(alojamientoDTO.getCiudad());
        alojamiento.setPrecio(alojamientoDTO.getPrecio());
        alojamiento.setTieneLavanderia(alojamientoDTO.isTieneLavanderia());
        alojamiento.setTieneRoomie(alojamientoDTO.isTieneRoomie());
        alojamiento.setTieneParqueaderoBicicleta(alojamientoDTO.isTieneParqueaderoBicicleta());
        return alojamiento;
    }


}
