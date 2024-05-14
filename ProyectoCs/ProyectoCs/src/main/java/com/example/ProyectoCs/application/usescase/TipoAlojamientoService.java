package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.TipoAlojamientoDTO;
import com.example.ProyectoCs.domain.model.TipoAlojamiento;
import com.example.ProyectoCs.domain.repository.TipoAlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoAlojamientoService {

    @Autowired
    private TipoAlojamientoRepository tipoAlojamientoRepository;

    public void saveTipoAlojamiento(TipoAlojamientoDTO tipoAlojamientoDTO) {
        TipoAlojamiento tipoAlojamiento = convertToEntity(tipoAlojamientoDTO);
        tipoAlojamientoRepository.save(tipoAlojamiento);
    }

    private TipoAlojamiento convertToEntity(TipoAlojamientoDTO tipoAlojamientoDTO) {
        TipoAlojamiento tipoAlojamiento = new TipoAlojamiento();
        tipoAlojamiento.setTipoAlojamientoID(tipoAlojamientoDTO.getTipoAlojamientoID());
        tipoAlojamiento.setNombreTipoAlojamiento(tipoAlojamientoDTO.getNombreTipoAlojamiento());
        return tipoAlojamiento;
    }
}
