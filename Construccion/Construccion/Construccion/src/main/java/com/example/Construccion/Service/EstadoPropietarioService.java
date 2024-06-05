package com.example.Construccion.Service;

import com.example.Construccion.entity.EstadoPropietario;
import com.example.Construccion.Repository.EstadoPropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoPropietarioService {

    private final EstadoPropietarioRepository estadoPropietarioRepository;

    @Autowired
    public EstadoPropietarioService(EstadoPropietarioRepository estadoPropietarioRepository) {
        this.estadoPropietarioRepository = estadoPropietarioRepository;
    }

    public List<EstadoPropietario> getAllEstadosPropietario() {
        return estadoPropietarioRepository.findAllEstadosPropietario();
    }

    public EstadoPropietario getEstadoPropietarioById(int id) {
        return estadoPropietarioRepository.findEstadoPropietarioById(id);
    }

    @Transactional
    public EstadoPropietario createEstadoPropietario(EstadoPropietario estadoPropietario) {
        return estadoPropietarioRepository.save(estadoPropietario);
    }

    @Transactional
    public EstadoPropietario updateEstadoPropietario(int id, EstadoPropietario estadoPropietario) {
        EstadoPropietario existingEstadoPropietario = estadoPropietarioRepository.findEstadoPropietarioById(id);
        if (existingEstadoPropietario == null) {
            return null;
        }
        existingEstadoPropietario.setEstadoPropietario(estadoPropietario.getEstadoPropietario());
        return estadoPropietarioRepository.save(existingEstadoPropietario);
    }

    @Transactional
    public void deleteEstadoPropietario(int id) {
        estadoPropietarioRepository.deleteById(id);
    }
}
