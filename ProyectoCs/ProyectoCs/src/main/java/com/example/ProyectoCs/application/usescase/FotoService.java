package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.FotoDTO;
import com.example.ProyectoCs.domain.model.Alojamiento;
import com.example.ProyectoCs.domain.model.Foto;
import com.example.ProyectoCs.domain.repository.AlojamientoRepository;
import com.example.ProyectoCs.domain.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public void saveFoto(FotoDTO fotoDTO) {
        Foto foto = convertToEntity(fotoDTO);
        fotoRepository.save(foto);
    }

    private Foto convertToEntity(FotoDTO fotoDTO) {
        Foto foto = new Foto();
        foto.setIdFoto(fotoDTO.getIdFoto());
        foto.setUrl(fotoDTO.getUrl());

        Alojamiento alojamiento = alojamientoRepository.findById(fotoDTO.getIdAlojamiento()).orElseThrow(() -> new IllegalArgumentException("Alojamiento no encontrado"));
        foto.setAlojamiento(alojamiento);

        return foto;
    }
}
