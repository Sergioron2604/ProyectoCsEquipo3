package com.example.Construccion.Service;

import com.example.Construccion.entity.EstadoEstudiante;
import com.example.Construccion.Repository.EstadoEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EstadoEstudianteService {

    @Autowired
    private EstadoEstudianteRepository estadoEstudianteRepository;

    public EstadoEstudiante saveEstadoEstudiante(EstadoEstudiante estadoEstudiante) {
        return estadoEstudianteRepository.save(estadoEstudiante);
    }

    public EstadoEstudiante updateEstadoEstudiante(int idEstadoEstudiante, String estadoEstudiante) {
        EstadoEstudiante estadoEstudianteToUpdate = estadoEstudianteRepository.findEstadoEstudianteById(idEstadoEstudiante);
        if (estadoEstudianteToUpdate != null) {
            estadoEstudianteToUpdate.setEstadoEstudiante(estadoEstudiante);
            return estadoEstudianteRepository.save(estadoEstudianteToUpdate);
        }
        return null;
    }

    public void deleteEstadoEstudiante(int idEstadoEstudiante) {
        estadoEstudianteRepository.deleteEstadoEstudiante(idEstadoEstudiante);
    }

    public List<EstadoEstudiante> getAllEstadosEstudiante() {
        return estadoEstudianteRepository.findAllEstadosEstudiante();
    }

    public EstadoEstudiante getEstadoEstudianteById(int idEstadoEstudiante) {
        return estadoEstudianteRepository.findEstadoEstudianteById(idEstadoEstudiante);
    }
}
