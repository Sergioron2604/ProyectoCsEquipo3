package com.springboot.myspringboot.service;
import com.springboot.myspringboot.entity.Estudiante;
import com.springboot.myspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Estudiante> getEstudiante() {
        return studentRepository.findAll();
    }

    public Optional<Estudiante> getEstudiante(Long id) {
        return studentRepository.findById(id);
    }

    public void saveOrUpdateEstudiante(Estudiante estudiante) {
        studentRepository.save(estudiante);
    }

    public void deleteEstudiante(Long id) {
        studentRepository.deleteById(id);
    }


}
