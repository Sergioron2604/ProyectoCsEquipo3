package com.example.Construccion.Controller;

import com.example.Construccion.entity.EstudianteReserva;
import com.example.Construccion.Service.EstudianteReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantes-reservas")
public class EstudianteReservaController {

    private final EstudianteReservaService estudianteReservaService;

    @Autowired
    public EstudianteReservaController(EstudianteReservaService estudianteReservaService) {
        this.estudianteReservaService = estudianteReservaService;
    }

    @PostMapping("/{idReserva}/{idEstudiante}")
    public void crearEstudianteReserva(@PathVariable long idEstudiante, @PathVariable long idReserva) {
        estudianteReservaService.crearEstudianteReserva(idEstudiante, idReserva);
    }

    @DeleteMapping("/{idReserva}/{idEstudiante}")
    public void borrarEstudianteReserva(@PathVariable long idEstudiante, @PathVariable long idReserva) {
        estudianteReservaService.borrarEstudianteReserva(idEstudiante, idReserva);
    }

    @PutMapping("/{idReserva}/{idEstudiante}")
    public void actualizarEstudianteReserva(@PathVariable long idEstudiante, @PathVariable long newIdEstudiante, @PathVariable long newIdReserva) {
        estudianteReservaService.actualizarEstudianteReserva(idEstudiante, newIdEstudiante, newIdReserva);
    }

    @GetMapping("/{idReserva}/{idEstudiante}")
    public EstudianteReserva buscarEstudianteReserva(@PathVariable long idEstudiante, @PathVariable long idReserva) {
        return estudianteReservaService.buscarEstudianteReserva(idEstudiante, idReserva);
    }

    @GetMapping
    public List<EstudianteReserva> findAll() {
        return estudianteReservaService.findAll();
    }
}
