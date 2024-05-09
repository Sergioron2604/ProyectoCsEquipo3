package com.example.Construccion.PreferenciaEstudiante.Servicios;

import com.example.Construccion.PreferenciaEstudiante.Modelo.PreferenciaEstudiante;
import com.example.Construccion.PreferenciaEstudiante.Repositorio.PreferenciaEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenciaEstudianteService {

    private final PreferenciaEstudianteRepository preferenciaEstudianteRepository;

    @Autowired
    public PreferenciaEstudianteService(PreferenciaEstudianteRepository preferenciaEstudianteRepository) {
        this.preferenciaEstudianteRepository = preferenciaEstudianteRepository;
    }

    public void insertPreferenciaEstudiante(int idPreferencia, int idEstudiante, double presupuestoMaximo, boolean deseaRoomie, boolean deseaLavanderia, boolean necesitaParqueaderoBicicleta) {
        preferenciaEstudianteRepository.insertPreferenciaEstudiante(idPreferencia, idEstudiante, presupuestoMaximo, deseaRoomie, deseaLavanderia, necesitaParqueaderoBicicleta);
    }

    public void updatePreferenciaEstudiante(int idPreferencia, int idEstudiante, double presupuestoMaximo, boolean deseaRoomie, boolean deseaLavanderia, boolean necesitaParqueaderoBicicleta) {
        preferenciaEstudianteRepository.updatePreferenciaEstudiante(idPreferencia, idEstudiante, presupuestoMaximo, deseaRoomie, deseaLavanderia, necesitaParqueaderoBicicleta);
    }

    public void deletePreferenciaEstudiante(int idPreferencia, int idEstudiante) {
        preferenciaEstudianteRepository.deletePreferenciaEstudiante(idPreferencia, idEstudiante);
    }

    public PreferenciaEstudiante findPreferenciaEstudianteById(int idPreferencia, int idEstudiante) {
        return preferenciaEstudianteRepository.findPreferenciaEstudianteById(idPreferencia, idEstudiante);
    }

    public List<PreferenciaEstudiante> findAllPreferenciasEstudiantes() {
        return preferenciaEstudianteRepository.findAllPreferenciasEstudiantes();
    }
}

