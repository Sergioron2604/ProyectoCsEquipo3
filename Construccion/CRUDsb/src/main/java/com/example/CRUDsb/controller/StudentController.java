package com.springboot.myspringboot.controller;

import com.springboot.myspringboot.entity.Estudiante;
import com.springboot.myspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Estudiante")
public class StudentController {

    private final StudentService studentService;

    @Autowired // Añadí la anotación @Autowired para la inyección de dependencia
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Estudiante> getAll(){
        return studentService.getEstudiante(); //
    }

    @GetMapping("/{studentId}")
    public Estudiante getById(@PathVariable("studentId") Long studentId) {
        return studentService.getEstudiante(studentId).orElse(null);
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Estudiante estudiante){
        studentService.saveOrUpdateEstudiante(estudiante);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        studentService.deleteEstudiante(studentId);
    }

}


