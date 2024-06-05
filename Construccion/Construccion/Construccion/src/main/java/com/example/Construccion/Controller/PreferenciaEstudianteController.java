package com.example.Construccion.Controller;

import com.example.Construccion.entity.PreferenciaEstudiante;
import com.example.Construccion.Service.PreferenciaEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/preferencias-estudiante")
public class PreferenciaEstudianteController {

    private final PreferenciaEstudianteService preferenciaEstudianteService;

    @Autowired
    public PreferenciaEstudianteController(PreferenciaEstudianteService preferenciaEstudianteService) {
        this.preferenciaEstudianteService = preferenciaEstudianteService;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarPreferenciaEstudiante(@RequestBody PreferenciaEstudiante preferenciaEstudiante) {
        preferenciaEstudianteService.insertPreferenciaEstudiante(
                preferenciaEstudiante.getIdPreferencia(),
                preferenciaEstudiante.getEstudiante().getIdEstudiante(),
                preferenciaEstudiante.getPresupuestoMaximo(),
                preferenciaEstudiante.isDeseaRoomie(),
                preferenciaEstudiante.isDeseaLavanderia(),
                preferenciaEstudiante.isNecesitaParqueaderoBicicleta()
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{idPreferencia}/{idEstudiante}")
    public ResponseEntity<Void> actualizarPreferenciaEstudiante(@PathVariable int idPreferencia, @PathVariable int idEstudiante, @RequestBody PreferenciaEstudiante preferenciaEstudiante) {
        preferenciaEstudianteService.updatePreferenciaEstudiante(
                idPreferencia,
                idEstudiante,
                preferenciaEstudiante.getPresupuestoMaximo(),
                preferenciaEstudiante.isDeseaRoomie(),
                preferenciaEstudiante.isDeseaLavanderia(),
                preferenciaEstudiante.isNecesitaParqueaderoBicicleta()
        );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{idPreferencia}/{idEstudiante}")
    public ResponseEntity<Void> eliminarPreferenciaEstudiante(@PathVariable int idPreferencia, @PathVariable int idEstudiante) {
        preferenciaEstudianteService.deletePreferenciaEstudiante(idPreferencia, idEstudiante);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idPreferencia}/{idEstudiante}")
    public ResponseEntity<PreferenciaEstudiante> obtenerPreferenciaEstudiantePorId(@PathVariable int idPreferencia, @PathVariable int idEstudiante) {
        PreferenciaEstudiante preferenciaEstudiante = preferenciaEstudianteService.findPreferenciaEstudianteById(idPreferencia, idEstudiante);
        if (preferenciaEstudiante != null) {
            return new ResponseEntity<>(preferenciaEstudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<PreferenciaEstudiante>> getAllPreferenciasEstudiantes() {
        List<PreferenciaEstudiante> preferenciasEstudiantes = preferenciaEstudianteService.findAllPreferenciasEstudiantes();
        return new ResponseEntity<>(preferenciasEstudiantes, HttpStatus.OK);
    }
}
