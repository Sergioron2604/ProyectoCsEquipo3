package com.example.Construccion.Habitaciones.Servicios;

import com.example.Construccion.Habitaciones.Modelo.Foto;
import com.example.Construccion.Habitaciones.Repositorio.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    @Autowired
    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public List<Foto> findAllFotos() {
        return fotoRepository.findAll();
    }

    public Foto findFotoById(int id) {
        return fotoRepository.findById(id).orElse(null);
    }

    public List<Foto> findFotosByHabitacion(int idHabitacion) {
        return fotoRepository.findFotosByHabitacion(idHabitacion);
    }

    public Foto saveFoto(Foto foto) {
        return fotoRepository.save(foto);
    }

    public void deleteFoto(int id) {
        fotoRepository.deleteById(id);
    }

    public boolean existsFoto(int id) {
        return fotoRepository.existsById(id);
    }
}
