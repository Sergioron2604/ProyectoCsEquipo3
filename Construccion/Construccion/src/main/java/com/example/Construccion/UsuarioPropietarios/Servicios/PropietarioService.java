package com.example.Construccion.UsuarioPropietarios.Servicios;

import com.example.Construccion.UsuarioPropietarios.Modelo.Propietario;
import com.example.Construccion.UsuarioPropietarios.Repositorio.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    @Autowired
    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public void insertPropietario(int idPropietario, String nombre, String email, String telefono, int idEstado, int idUniversidad)
    {
        propietarioRepository.insertPropietario(idPropietario, nombre, email, telefono, idEstado, idUniversidad);
    }

    public void updatePropietario(int idPropietario, String nombre, String email, String telefono, int idEstado, int idUniversidad)
    {
        propietarioRepository.updatePropietario(idPropietario, nombre, email, telefono, idEstado, idUniversidad);
    }

    public void deletePropietario(int idPropietario) {
        propietarioRepository.deletePropietario(idPropietario);
    }

    public List<Propietario> findAllPropietarios() {
        return propietarioRepository.findAllPropietarios();
    }

    public Propietario findPropietarioById(int idPropietario) {
        return propietarioRepository.findPropietarioBy(idPropietario);
    }
}
