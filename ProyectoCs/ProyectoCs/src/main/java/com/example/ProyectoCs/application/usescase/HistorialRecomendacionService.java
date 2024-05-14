package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.HistorialRecomendacionDTO;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.model.HistorialRecomendacion;
import com.example.ProyectoCs.domain.model.Recomendacion;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import com.example.ProyectoCs.domain.repository.HistorialRecomendacionRepository;
import com.example.ProyectoCs.domain.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HistorialRecomendacionService {

    @Autowired
    private HistorialRecomendacionRepository historialRecomendacionRepository;

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    public void guardarHistorialRecomendacion(HistorialRecomendacionDTO historialRecomendacionDTO) {
        // Buscar la recomendación por su ID
        Recomendacion recomendacion = recomendacionRepository.findById(historialRecomendacionDTO.getIdRecomendacion())
                .orElseThrow(() -> new IllegalArgumentException("Recomendación no encontrada"));

        // Busca al estudiante por su UUID
        Estudiante estudiante = estudianteRepository.findById(UUID.fromString(String.valueOf(historialRecomendacionDTO.getIdEstudiante())))
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));

        // Crear una nueva instancia de HistorialRecomendacion
        HistorialRecomendacion historialRecomendacion = new HistorialRecomendacion();
        historialRecomendacion.setRecomendacion(recomendacion);
        historialRecomendacion.setEstudiante(estudiante);
        historialRecomendacion.setFechaRecomendacion(historialRecomendacionDTO.getFechaRecomendacion());
        historialRecomendacion.setAlojamientosRecomendados(historialRecomendacionDTO.getAlojamientosRecomendados());

        // Guardar el historial de recomendación
        historialRecomendacionRepository.save(historialRecomendacion);
    }
}
