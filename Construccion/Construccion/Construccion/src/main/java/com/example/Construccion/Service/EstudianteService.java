package com.example.Construccion.Service;

import com.example.Construccion.entity.Estudiante;
import com.example.Construccion.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudianteById(int id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Transactional
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    public Estudiante updateEstudiante(int id, Estudiante estudiante) {
        Estudiante existingEstudiante = estudianteRepository.findById(id).orElse(null);
        if (existingEstudiante == null) {
            return null;
        }
        existingEstudiante.setNombre(estudiante.getNombre());
        existingEstudiante.setEmail(estudiante.getEmail());
        existingEstudiante.setTelefono(estudiante.getTelefono());
        existingEstudiante.setUniversidad(estudiante.getUniversidad());
        existingEstudiante.setEstadoEstudiante(estudiante.getEstadoEstudiante());
        return estudianteRepository.save(existingEstudiante);
    }


    @Transactional
    public boolean deleteEstudiante(int id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
