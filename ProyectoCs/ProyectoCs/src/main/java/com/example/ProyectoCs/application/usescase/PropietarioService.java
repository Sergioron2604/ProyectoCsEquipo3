package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.domain.model.EstadoPropietario;
import com.example.ProyectoCs.domain.model.Propietario;
import com.example.ProyectoCs.domain.repository.EstadoPropietarioRepository;
import com.example.ProyectoCs.domain.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private EstadoPropietarioRepository estadoPropietarioRepository;

    public void savePropietario(PropietarioDTO propietarioDTO) {
        Propietario propietario = convertToEntity(propietarioDTO);
        propietarioRepository.save(propietario);
    }

    private Propietario convertToEntity(PropietarioDTO propietarioDTO) {
        Propietario propietario = new Propietario();
        propietario.setIdPropietario(propietarioDTO.getIdPropietario());
        propietario.setNombre(propietarioDTO.getNombre());
        propietario.setEmail(propietarioDTO.getEmail());
        propietario.setTelefono(propietarioDTO.getTelefono());

        EstadoPropietario estadoPropietario = estadoPropietarioRepository.findById(propietarioDTO.getIdEstadoPropietario())
                .orElseThrow(() -> new IllegalArgumentException("Estado de propietario no encontrado"));
        propietario.setEstadoPropietario(estadoPropietario);

        return propietario;
    }
}
