package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.ComentarioDTO;
import com.example.ProyectoCs.domain.model.Comentario;
import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.repository.ComentarioRepository;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ComentarioService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public void guardarComentario(ComentarioDTO comentarioDTO) {
        // Busca al estudiante por su UUID
        Estudiante estudiante = estudianteRepository.findById(UUID.fromString(String.valueOf(comentarioDTO.getIdEstudiante())))
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));



        // Crea un nuevo comentario y establece el estudiante
        Comentario comentario = new Comentario();
        comentario.setEstudiante(estudiante);
        comentario.setComentario(comentarioDTO.getComentario());

        // Guarda el comentario
        comentarioRepository.save(comentario);
    }
}

