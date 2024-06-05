package com.example.ProyectoCs.application.service;

import com.example.ProyectoCs.application.dto.FotoDTO;
import com.example.ProyectoCs.infrastructure.gateway.FotoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FotoService {

    private final FotoGateway fotoGateway;

    @Autowired
    public FotoService(FotoGateway fotoGateway) {
        this.fotoGateway = fotoGateway;
    }

    public String subirFoto(FotoDTO fotoDTO) throws IOException {
        return fotoGateway.uploadFoto(fotoDTO);
    }
}
