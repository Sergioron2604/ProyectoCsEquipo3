package com.example.Construccion.Service;

import com.example.Construccion.entity.Historial;
import com.example.Construccion.Repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;

    @Autowired
    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public void insertHistorial(int idHistorial, int idEntidadAfectada, String tipoEntidad, int idEstadoAnterior, int idEstadoNuevo, Date fechaHoraCambio) {
        historialRepository.insertHistorial(idHistorial, idEntidadAfectada, tipoEntidad, idEstadoAnterior, idEstadoNuevo, fechaHoraCambio);
    }

    public void updateHistorial(int idHistorial, int idEntidadAfectada, String tipoEntidad, int idEstadoAnterior, int idEstadoNuevo, Date fechaHoraCambio) {
        historialRepository.updateHistorial(idHistorial, idEntidadAfectada, tipoEntidad, idEstadoAnterior, idEstadoNuevo, fechaHoraCambio);
    }

    public void deleteHistorial(int idHistorial) {
        historialRepository.deleteHistorial(idHistorial);
    }

    public List<Historial> findAllHistorial() {
        return historialRepository.findAllHistorial();
    }
}
