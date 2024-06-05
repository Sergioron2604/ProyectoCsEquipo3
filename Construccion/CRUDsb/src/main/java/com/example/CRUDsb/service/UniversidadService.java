package com.example.CRUDsb.service;

import com.example.CRUDsb.entity.Universidad;
import com.example.CRUDsb.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversidadService {
    @Autowired
    UniversidadRepository universidadRepository;

    public List<Universidad> getUniversidad(){


        return universidadRepository.findAll();
    }

    public Optional<Universidad> getUniversidades(Long id){

        return universidadRepository.findById(id);
    }

    public void saveOrUptdate(Universidad universidad){

        universidadRepository.save(universidad);

    }

    public void delete(Long id){

        universidadRepository.deleteById(id);

    }
}
