package com.example.Construccion.Controller;

import com.example.Construccion.entity.Comentario;
import com.example.Construccion.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping("/habitacion/{idHabitacion}")
    public ResponseEntity<List<Comentario>> getComentariosByHabitacion(@PathVariable("idHabitacion") int idHabitacion) {
        List<Comentario> comentarios = comentarioService.getComentariosByHabitacion(idHabitacion);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public ResponseEntity<List<Comentario>> getComentariosByEstudiante(@PathVariable("idEstudiante") int idEstudiante) {
        List<Comentario> comentarios = comentarioService.getComentariosByEstudiante(idEstudiante);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveComentario(@RequestBody Comentario comentario) {
        comentarioService.saveComentario(comentario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{idComentario}")
    public ResponseEntity<Void> deleteComentario(@PathVariable("idComentario") int idComentario) {
        comentarioService.deleteComentario(idComentario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}