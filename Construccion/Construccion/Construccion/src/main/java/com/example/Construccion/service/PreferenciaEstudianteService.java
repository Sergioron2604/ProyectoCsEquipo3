package com.example.Construccion.service;

import com.example.Construccion.entity.PreferenciaEstudiante;
import com.example.Construccion.repository.PreferenciaEstudianteRepository;
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


    public void insertPreferenciaEstudiante(int idPreferencia, int idEstudiante, String tipoEspacio, double presupuestoMaximo, double distanciaMaxima, boolean deseaRoomie, boolean necesitaParqueaderoBicicleta) {
        preferenciaEstudianteRepository.insertPreferenciaEstudiante(idPreferencia, idEstudiante, tipoEspacio, presupuestoMaximo, distanciaMaxima, deseaRoomie, necesitaParqueaderoBicicleta);
    }


    public void updatePreferenciaEstudiante(int idPreferencia, int idEstudiante, String tipoEspacio, double presupuestoMaximo, double distanciaMaxima, boolean deseaRoomie, boolean necesitaParqueaderoBicicleta) {
        preferenciaEstudianteRepository.updatePreferenciaEstudiante(idPreferencia, idEstudiante, tipoEspacio, presupuestoMaximo, distanciaMaxima, deseaRoomie, necesitaParqueaderoBicicleta);
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
