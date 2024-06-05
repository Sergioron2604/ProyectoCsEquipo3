package com.example.ProyectoCs.application.service;

import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Estudiante estudiante = estudianteRepository.findByEmail(email);
        if (estudiante == null) {
            throw new UsernameNotFoundException("Estudiante no encontrado con el email: " + email);
        }

        return org.springframework.security.core.userdetails.User.withUsername(estudiante.getEmail())
                .password(estudiante.getContraseña())
                .roles("ESTUDIANTE")
                .build();
    }

    public void save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }
}
