package com.example.CRUDsb.controller;

import com.example.CRUDsb.entity.Universidad;
import com.example.CRUDsb.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/universidades")
public class UniversidadController {

    @Autowired
    private UniversidadService universidadService;


    @GetMapping
    public List<Universidad> getAll(){
        return universidadService.getUniversidad();
    }


    @GetMapping("/{id_universidad}")
    public Optional<Universidad> getById(@PathVariable("id_universidad")Long universidadId){
        return universidadService.getUniversidades(universidadId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Universidad universidad){
        universidadService.saveOrUptdate(universidad);
    }

    @DeleteMapping("/{id_universidad}")
    public void saveUpdate(@PathVariable("id_universidad") Long universidadId){
        universidadService.delete(universidadId);
    }
}
