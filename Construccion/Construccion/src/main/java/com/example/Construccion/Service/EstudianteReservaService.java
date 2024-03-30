package com.example.Construccion.service;

import com.example.Construccion.entity.EstudianteReserva;
import com.example.Construccion.repository.EstudianteReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteReservaService {

    private final EstudianteReservaRepository estudianteReservaRepository;

    @Autowired
    public EstudianteReservaService(EstudianteReservaRepository estudianteReservaRepository) {
        this.estudianteReservaRepository = estudianteReservaRepository;
    }

    public void crearEstudianteReserva(long idEstudiante, long idReserva) {
        estudianteReservaRepository.crearEstudianteReserva(idEstudiante, idReserva);
    }

    public void borrarEstudianteReserva(long idEstudiante, long idReserva) {
        estudianteReservaRepository.borrarEstudianteReserva(idEstudiante, idReserva);
    }

    public void actualizarEstudianteReserva(long idEstudiante, long newIdEstudiante, long newIdReserva) {
        estudianteReservaRepository.actualizarEstudianteReserva(idEstudiante, newIdEstudiante, newIdReserva);
    }

    public EstudianteReserva buscarEstudianteReserva(long idEstudiante, long idReserva) {
        return estudianteReservaRepository.buscarEstudianteReserva(idEstudiante, idReserva);
    }

    public List<EstudianteReserva> findAll() {
        return estudianteReservaRepository.findAll();
    }
}
