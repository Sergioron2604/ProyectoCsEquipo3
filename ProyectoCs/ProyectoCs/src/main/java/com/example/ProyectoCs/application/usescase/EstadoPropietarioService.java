package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstadoPropietarioDTO;
import com.example.ProyectoCs.domain.model.EstadoPropietario;
import com.example.ProyectoCs.domain.repository.EstadoPropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoPropietarioService {

    @Autowired
    private EstadoPropietarioRepository estadoPropietarioRepository;

    public void saveEstadoPropietario(EstadoPropietarioDTO estadoPropietarioDTO) {
        EstadoPropietario estadoPropietario = convertToEntity(estadoPropietarioDTO);
        estadoPropietarioRepository.save(estadoPropietario);
    }

    private EstadoPropietario convertToEntity(EstadoPropietarioDTO estadoPropietarioDTO) {
        EstadoPropietario estadoPropietario = new EstadoPropietario();
        estadoPropietario.setIdEstadoPropietario(estadoPropietarioDTO.getIdEstadoPropietario());
        estadoPropietario.setEstadoPropietario(estadoPropietarioDTO.getEstadoPropietario());
        return estadoPropietario;
    }
}
