package com.example.CRUDsb.controller;

import com.example.CRUDsb.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(path = "api/v3/habitaciones")
public class HUPrecio {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/{id_habitacion}/precio")
    public ResponseEntity<Double> obtenerPrecioPorId(@PathVariable("id_habitacion") Long idHabitacion) {
        Optional<Double> precio = habitacionService.obtenerPrecioPorId(idHabitacion);

        if (precio.isPresent()) {
            return ResponseEntity.ok(precio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
