package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.HistorialDTO;
import com.example.ProyectoCs.domain.model.Historial;
import com.example.ProyectoCs.domain.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    public void saveHistorial(HistorialDTO historialDTO) {
        Historial historial = convertToEntity(historialDTO);
        historialRepository.save(historial);
    }

    private Historial convertToEntity(HistorialDTO historialDTO) {
        Historial historial = new Historial();
        historial.setIdHistorial(historialDTO.getIdHistorial());
        historial.setIdEntidadAfectada(historialDTO.getIdEntidadAfectada());
        historial.setTipoEntidad(historialDTO.getTipoEntidad());
        historial.setIdEstadoAnterior(historialDTO.getIdEstadoAnterior());
        historial.setIdEstadoNuevo(historialDTO.getIdEstadoNuevo());
        historial.setFechaHoraCambio(historialDTO.getFechaHoraCambio());
        return historial;
    }
}
