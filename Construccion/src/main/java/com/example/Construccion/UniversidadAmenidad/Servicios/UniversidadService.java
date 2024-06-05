package com.example.Construccion.UniversidadAmenidad.Servicios;

import com.example.Construccion.UniversidadAmenidad.Modelo.Universidad;
import com.example.Construccion.UniversidadAmenidad.Repositorio.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversidadService {

    private final UniversidadRepository universidadRepository;

    @Autowired
    public UniversidadService(UniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }

    public void saveUniversidad(int idUniversidad, String nombreUniversidad, String direccion, String ciudad) {
        universidadRepository.saveUniversidad(idUniversidad, nombreUniversidad, direccion, ciudad);
    }

    public void updateUniversidad(int idUniversidad, String nombreUniversidad, String direccion, String ciudad) {
        universidadRepository.updateUniversidad(idUniversidad, nombreUniversidad, direccion, ciudad);
    }

    public void deleteUniversidad(int idUniversidad) {
        universidadRepository.deleteUniversidad(idUniversidad);
    }

    public List<Universidad> findAllUniversidades() {
        return universidadRepository.findAllUniversidades();
    }
}
