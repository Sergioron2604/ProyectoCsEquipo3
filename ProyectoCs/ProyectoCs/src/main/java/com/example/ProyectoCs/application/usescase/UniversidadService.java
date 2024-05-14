package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.UniversidadDTO;
import com.example.ProyectoCs.domain.model.Universidad;
import com.example.ProyectoCs.domain.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversidadService {

    @Autowired
    private UniversidadRepository universidadRepository;

    public void saveUniversidad(UniversidadDTO universidadDTO) {
        Universidad universidad = convertToEntity(universidadDTO);
        universidadRepository.save(universidad);
    }

    private Universidad convertToEntity(UniversidadDTO universidadDTO) {
        Universidad universidad = new Universidad();
        universidad.setIdUniversidad(universidadDTO.getIdUniversidad());
        universidad.setNombreUniversidad(universidadDTO.getNombreUniversidad());
        universidad.setDireccion(universidadDTO.getDireccion());
        universidad.setCiudad(universidadDTO.getCiudad());
        return universidad;
    }
}
