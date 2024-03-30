package com.springboot.myspringboot.controller;

import com.springboot.myspringboot.entity.Estudiante;
import com.springboot.myspringboot.entity.PreferenciasEstudiante;
import com.springboot.myspringboot.service.PreferenceStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/preferencias")
public class PreferenceStudentController {

    private final PreferenceStudentService preferenceStudentService;

    @Autowired
    public PreferenceStudentController(PreferenceStudentService preferenceStudentService) {
        this.preferenceStudentService = preferenceStudentService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<?> guardarOActualizarPreferencias(@PathVariable("studentId") Long studentId,
                                                            @RequestBody PreferenciasEstudiante preferenciasEstudiante) {
        if (preferenciasEstudiante.getPresupuestoMaximo() == null || preferenciasEstudiante.getDistanciaMaxima() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El presupuesto máximo y la distancia máxima son obligatorios");
        }


        Estudiante estudiante = new Estudiante();
        estudiante.setStudentId(studentId);
        preferenciasEstudiante.setEstudiante(estudiante);

        preferenceStudentService.guardarOActualizarPreferencias(studentId, preferenciasEstudiante);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> actualizarPreferencias(@PathVariable("studentId") Long studentId,
                                                    @RequestBody PreferenciasEstudiante preferenciasEstudiante) {
        if (preferenciasEstudiante.getPresupuestoMaximo() == null || preferenciasEstudiante.getDistanciaMaxima() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El presupuesto máximo y la distancia máxima son obligatorios");
        }

        preferenceStudentService.guardarOActualizarPreferencias(studentId, preferenciasEstudiante);
        return ResponseEntity.ok().build();
    }
}


