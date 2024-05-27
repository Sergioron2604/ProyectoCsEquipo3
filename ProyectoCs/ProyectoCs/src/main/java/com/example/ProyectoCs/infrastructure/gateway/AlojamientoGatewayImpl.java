package com.example.ProyectoCs.infrastructure.gateway;

import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.application.dto.PreferenciaEstudianteDTO;
import com.example.ProyectoCs.application.service.NotificationService;
import com.example.ProyectoCs.domain.model.Alojamiento;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.repository.AlojamientoRepository;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AlojamientoGatewayImpl implements AlojamientoGateway {

    private final AlojamientoRepository alojamientoRepository;
    private final EstudianteRepository estudianteRepository;
    private final NotificationService notificationService;

    @Autowired
    public AlojamientoGatewayImpl(AlojamientoRepository alojamientoRepository,
                                  EstudianteRepository estudianteRepository,
                                  NotificationService notificationService) {
        this.alojamientoRepository = alojamientoRepository;
        this.estudianteRepository = estudianteRepository;
        this.notificationService = notificationService;
    }

    @Override
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

    @Override
    public void crearNuevaHabitacion(AlojamientoDTO alojamientoDTO) throws MessagingException, jakarta.mail.MessagingException {
        Alojamiento alojamiento = convertirDTOaEntidad(alojamientoDTO);
        alojamiento.getEstadoHabitacion().setIdEstadoHabitacion(1);
        Alojamiento nuevaHabitacion = alojamientoRepository.save(alojamiento);
        List<Estudiante> estudiantes = obtenerTodosLosEstudiantes();
        String mensaje = "¡Hola estudiantes! Se ha creado una nueva habitación en nuestra plataforma.";
        for (Estudiante estudiante : estudiantes) {
            //;
        }
    }

    @Override
    public Map<String, Object> compararAlojamientos(int idAlojamiento1, int idAlojamiento2) {
        Alojamiento alojamiento1 = alojamientoRepository.findById(idAlojamiento1)
                .orElseThrow(() -> new IllegalArgumentException("Alojamiento 1 no encontrado"));
        Alojamiento alojamiento2 = alojamientoRepository.findById(idAlojamiento2)
                .orElseThrow(() -> new IllegalArgumentException("Alojamiento 2 no encontrado"));

        AlojamientoDTO alojamientoDTO1 = convertirEntidadADTO(alojamiento1);
        AlojamientoDTO alojamientoDTO2 = convertirEntidadADTO(alojamiento2);

        Map<String, Object> comparacion = new HashMap<>();
        comparacion.put("Alojamiento 1", alojamientoDTO1);
        comparacion.put("Alojamiento 2", alojamientoDTO2);

        return comparacion;
    }

    @Override
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

    private List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    private AlojamientoDTO convertirEntidadADTO(Alojamiento alojamiento) {
        return new AlojamientoDTO(
                alojamiento.getIdAlojamiento(),
                alojamiento.getNombreAlojamiento(),
                alojamiento.getDescripcion(),
                alojamiento.getDireccion(),
                alojamiento.getCiudad(),
                alojamiento.getPrecio(),
                (int) alojamiento.getPropietario().getIdPropietario(),
                alojamiento.getEstadoHabitacion().getIdEstadoHabitacion(),
                alojamiento.getTipoAlojamiento().getTipoAlojamientoID(),
                alojamiento.isTieneLavanderia(),
                alojamiento.isTieneRoomie(),
                alojamiento.isTieneParqueaderoBicicleta()
        );
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
