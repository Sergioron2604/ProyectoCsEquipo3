package com.example.Construccion.UsuarioPropietarios.Servicios;

import com.example.Construccion.UsuarioPropietarios.Modelo.Estudiante;
import com.example.Construccion.UsuarioPropietarios.Repositorio.EstudianteRepository;
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
        return estudianteRepository.findAllEstudiantes();
    }

    public Estudiante getEstudianteById(int id) {

        return estudianteRepository.findEstudianteById(id);
    }

    @Transactional
    public Estudiante createEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    public Estudiante updateEstudiante(int id, Estudiante estudiante) {
        Estudiante existingEstudiante = estudianteRepository.findEstudianteById(id);
        if (existingEstudiante == null) {
            // Manejar la excepción o retornar null, según la lógica de tu aplicación
            return null;
        }
        existingEstudiante.setNombre(estudiante.getNombre());
        existingEstudiante.setEdad(estudiante.getEdad());
        existingEstudiante.setEmail(estudiante.getEmail());
        existingEstudiante.setTelefono(estudiante.getTelefono());
        existingEstudiante.setUniversidad(estudiante.getUniversidad());
        existingEstudiante.setEstadoEstudiante(estudiante.getEstadoEstudiante());
        return estudianteRepository.save(existingEstudiante);
    }

    @Transactional
    public void deleteEstudiante(int id) {
        estudianteRepository.deleteEstudiante(id);
    }
}
