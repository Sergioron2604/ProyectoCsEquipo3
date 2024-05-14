package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.RecomendacionDTO;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.model.Recomendacion;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import com.example.ProyectoCs.domain.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional
    public void saveRecomendacion(RecomendacionDTO recomendacionDTO) {
        // Validar DTO
        if (recomendacionDTO == null) {
            throw new IllegalArgumentException("El DTO de recomendación es nulo");
        }

        // Convertir ID de Estudiante de String a UUID
        UUID estudianteId = UUID.fromString(String.valueOf(recomendacionDTO.getIdEstudiante()));

        // Buscar el estudiante por su UUID
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado con ID: " + recomendacionDTO.getIdEstudiante()));

        // Crear entidad Recomendacion y guardar en la base de datos
        Recomendacion recomendacion = new Recomendacion();
        recomendacion.setIdRecomendacion(recomendacionDTO.getIdRecomendacion());
        recomendacion.setFecha(recomendacionDTO.getFecha());
        recomendacion.setAlojamientosRecomendados(recomendacionDTO.getAlojamientosRecomendados());
        recomendacion.setRazon(recomendacionDTO.getRazon());
        recomendacion.setVisto(recomendacionDTO.isVisto());
        recomendacion.setEstudiante(estudiante);

        recomendacionRepository.save(recomendacion);
    }
}
