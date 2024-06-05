package com.example.Construccion.UniversidadAmenidad.Servicios;
import com.example.Construccion.UniversidadAmenidad.Modelo.Amenidad;
import com.example.Construccion.UniversidadAmenidad.Repositorio.AmenidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenidadService {

    private final AmenidadRepository amenidadRepository;

    @Autowired
    public AmenidadService(AmenidadRepository amenidadRepository) {
        this.amenidadRepository = amenidadRepository;
    }

    public List<Amenidad> getAllAmenidades() {
        return amenidadRepository.findAllAmenidades();
    }

    public Amenidad getAmenidadById(int id) {
        return amenidadRepository.findByIdAmenidad(id);
    }

    public Amenidad getAmenidadByNombre(String nombre) {
        return amenidadRepository.findByNombreAmenidad(nombre);
    }

    public void saveAmenidad(Amenidad amenidad) {
        amenidadRepository.insertAmenidad(amenidad.getNombreAmenidad());
    }

    public void updateAmenidad(Amenidad amenidad) {
        amenidadRepository.updateAmenidad(amenidad.getIdAmenidad(), amenidad.getNombreAmenidad());
    }

    public void deleteAmenidad(int id) {
        amenidadRepository.deleteAmenidadById(id);
    }
}
