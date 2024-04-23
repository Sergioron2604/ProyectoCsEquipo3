package com.example.Construccion.service;

import com.example.Construccion.entity.Foto;
import com.example.Construccion.entity.Habitacion;
import com.example.Construccion.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    // Configuración para primer escenario

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


    //Configuración Escenario #2
    public List<String> obtenerFormatosPermitidos() {
        List<String> formatosPermitidos = Arrays.asList("JPG", "PNG", "JPEG", "GIF");
        return formatosPermitidos;
    }
}
