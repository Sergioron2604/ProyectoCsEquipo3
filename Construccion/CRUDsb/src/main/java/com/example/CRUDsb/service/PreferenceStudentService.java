package com.springboot.myspringboot.service;

import com.springboot.myspringboot.entity.PreferenciasEstudiante;
import com.springboot.myspringboot.repository.PreferenciasEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceStudentService {

    private final PreferenciasEstudianteRepository preferenciasEstudianteRepository;

    @Autowired
    public PreferenceStudentService(PreferenciasEstudianteRepository preferenciasEstudianteRepository) {
        this.preferenciasEstudianteRepository = preferenciasEstudianteRepository;
    }

    public void guardarOActualizarPreferencias(Long studentId, PreferenciasEstudiante preferenciasEstudiante) {
        preferenciasEstudianteRepository.save(preferenciasEstudiante);
    }

}


