package com.example.CRUDsb.controller;

import com.example.CRUDsb.entity.Habitacion;
import com.example.CRUDsb.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;


    @GetMapping
    public List<Habitacion> getAll(){
        return habitacionService.getHabitacion();}


    @GetMapping("/{id_habitacion}")
    public Optional<Habitacion> getById(@PathVariable("id_habitacion")Long habitacionID){
        return habitacionService.getHabitaciones(habitacionID);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Habitacion habitacion){
        habitacionService.saveOrUpdate(habitacion);
    }

    @DeleteMapping("/{id_habitacion}")
    public void saveUpdate(@PathVariable("id_habitacion") Long habitacionId){
        habitacionService.delete(habitacionId);
    }



}
