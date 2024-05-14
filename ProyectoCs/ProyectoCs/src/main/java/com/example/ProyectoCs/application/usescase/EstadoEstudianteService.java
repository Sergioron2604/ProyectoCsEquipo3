package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstadoEstudianteDTO;
import com.example.ProyectoCs.domain.model.EstadoEstudiante;
import com.example.ProyectoCs.domain.repository.EstadoEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoEstudianteService {

    @Autowired
    private EstadoEstudianteRepository estadoEstudianteRepository;

    public void saveEstadoEstudiante(EstadoEstudianteDTO estadoEstudianteDTO) {
        EstadoEstudiante estadoEstudiante = convertToEntity(estadoEstudianteDTO);
        estadoEstudianteRepository.save(estadoEstudiante);
    }

    private EstadoEstudiante convertToEntity(EstadoEstudianteDTO estadoEstudianteDTO) {
        EstadoEstudiante estadoEstudiante = new EstadoEstudiante();
        estadoEstudiante.setIdEstadoEstudiante(estadoEstudianteDTO.getIdEstadoEstudiante());
        estadoEstudiante.setEstadoEstudiante(estadoEstudianteDTO.getEstadoEstudiante());
        return estadoEstudiante;
    }
}
