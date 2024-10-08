package com.example.Construccion.Commons.Controlador;

import com.example.Construccion.Commons.Modelo.EstudianteReserva;
import com.example.Construccion.Commons.Servicio.EstudianteReservaIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantesreserva")
public class EstudianteReservaIdController {

    private final EstudianteReservaIdService estudianteReservaIdService;

    @Autowired
    public EstudianteReservaIdController(EstudianteReservaIdService estudianteReservaIdService) {
        this.estudianteReservaIdService = estudianteReservaIdService;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertEstudianteReserva(@RequestParam("idEstudiante") int idEstudiante, @RequestParam("idReserva") int idReserva) {
        estudianteReservaIdService.insertEstudianteReserva(idEstudiante, idReserva);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deleteEstudianteReserva(@RequestParam("idEstudiante") int idEstudiante, @RequestParam("idReserva") int idReserva) {
        estudianteReservaIdService.deleteEstudianteReserva(idEstudiante, idReserva);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/reservas/{idEstudiante}")
    public ResponseEntity<List<EstudianteReserva>> findReservasByEstudiante(@PathVariable("idEstudiante") int idEstudiante) {
        List<EstudianteReserva> reservas = estudianteReservaIdService.findReservasByEstudiante(idEstudiante);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/estudiantes/{idReserva}")
    public ResponseEntity<List<EstudianteReserva>> findEstudiantesByReserva(@PathVariable("idReserva") int idReserva) {
        List<EstudianteReserva> estudiantes = estudianteReservaIdService.findEstudiantesByReserva(idReserva);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }
}
