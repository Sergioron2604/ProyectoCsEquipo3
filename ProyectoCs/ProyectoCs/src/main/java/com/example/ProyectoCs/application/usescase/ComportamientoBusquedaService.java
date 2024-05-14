package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.ComportamientoBusquedaDTO;
import com.example.ProyectoCs.domain.model.ComportamientoBusqueda;
import com.example.ProyectoCs.domain.repository.ComportamientoBusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComportamientoBusquedaService {

    @Autowired
    private ComportamientoBusquedaRepository comportamientoBusquedaRepository;

    public void saveComportamientoBusqueda(ComportamientoBusquedaDTO comportamientoBusquedaDTO) {
        ComportamientoBusqueda comportamientoBusqueda = convertToEntity(comportamientoBusquedaDTO);
        comportamientoBusquedaRepository.save(comportamientoBusqueda);
    }

    private ComportamientoBusqueda convertToEntity(ComportamientoBusquedaDTO comportamientoBusquedaDTO) {
        ComportamientoBusqueda comportamientoBusqueda = new ComportamientoBusqueda();
        comportamientoBusqueda.setIdBusqueda(comportamientoBusquedaDTO.getIdBusqueda());
        comportamientoBusqueda.setFechaHora(comportamientoBusquedaDTO.getFechaHora());
        comportamientoBusqueda.setCriteriosBusqueda(comportamientoBusquedaDTO.getCriteriosBusqueda());
        comportamientoBusqueda.setResultadosVistos(comportamientoBusquedaDTO.getResultadosVistos());
        comportamientoBusqueda.setFavoritos(comportamientoBusquedaDTO.getFavoritos());
        // Setear el Estudiante según tu lógica de negocio
        return comportamientoBusqueda;
    }
}
