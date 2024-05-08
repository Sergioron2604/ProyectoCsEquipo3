package com.example.Construccion.Habitaciones.Servicios;

import com.example.Construccion.Habitaciones.Modelo.Comentario;
import com.example.Construccion.Habitaciones.Repositorio.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<Comentario> getComentariosByHabitacion(int idHabitacion) {
        return comentarioRepository.findByHabitacion(idHabitacion);
    }

    public List<Comentario> getComentariosByEstudiante(int idEstudiante) {
        return comentarioRepository.findByEstudiante(idEstudiante);
    }

    public void saveComentario(Comentario comentario) {
        comentarioRepository.insertComentario(
                comentario.getIdComentario(),
                comentario.getHabitacion().getIdHabitacion(),
                comentario.getEstudiante().getIdEstudiante(),
                comentario.getComentario()
        );
    }

    public void updateComentario(Comentario comentario) {
        comentarioRepository.updateComentario(
                comentario.getIdComentario(),
                comentario.getComentario()
        );
    }

    public void deleteComentario(int idComentario) {
        comentarioRepository.deleteComentario(idComentario);
    }
}
