package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.domain.model.Alojamiento;
import com.example.ProyectoCs.domain.repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlojamientoService {

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public void saveAlojamiento(AlojamientoDTO alojamientoDTO) {
        Alojamiento alojamiento = convertToEntity(alojamientoDTO);
        alojamientoRepository.save(alojamiento);
    }

    private Alojamiento convertToEntity(AlojamientoDTO alojamientoDTO) {
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setIdAlojamiento(alojamientoDTO.getIdAlojamiento());
        alojamiento.setNombreAlojamiento(alojamientoDTO.getNombreAlojamiento());
        alojamiento.setDescripcion(alojamientoDTO.getDescripcion());
        alojamiento.setDireccion(alojamientoDTO.getDireccion());
        alojamiento.setCiudad(alojamientoDTO.getCiudad());
        alojamiento.setPrecio(alojamientoDTO.getPrecio());
        // Asignar el propietario, estadoHabitacion y tipoAlojamiento según sea necesario
        // alojamiento.setPropietario( ... );
        // alojamiento.setEstadoHabitacion( ... );
        // alojamiento.setTipoAlojamiento( ... );
        alojamiento.setTieneLavanderia(alojamientoDTO.isTieneLavanderia());
        alojamiento.setTieneRoomie(alojamientoDTO.isTieneRoomie());
        alojamiento.setTieneParqueaderoBicicleta(alojamientoDTO.isTieneParqueaderoBicicleta());
        return alojamiento;
    }
}
