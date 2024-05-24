/*
package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.domain.model.Alojamiento;
import com.example.ProyectoCs.domain.repository.AlojamientoRepository;
import com.example.ProyectoCs.domain.repository.EstudianteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.mail.MessagingException;
import java.util.Collections;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class AlojamientoServiceTest {
    private AlojamientoRepository alojamientoRepository;
    private EstudianteRepository estudianteRepository;
    private NotificationService notificationService;
    private AlojamientoService alojamientoService;

    @BeforeEach
    void setUp() {
        alojamientoRepository = Mockito.mock(AlojamientoRepository.class);
        estudianteRepository = Mockito.mock(EstudianteRepository.class);
        notificationService = Mockito.mock(NotificationService.class);
        alojamientoService = new AlojamientoService(alojamientoRepository, estudianteRepository, notificationService);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void crearNuevaHabitacion() throws MessagingException, jakarta.mail.MessagingException {
        AlojamientoDTO alojamientoDTO = new AlojamientoDTO();
        alojamientoDTO.setIdAlojamiento(1);
        when(alojamientoRepository.save(any(Alojamiento.class))).thenReturn(new Alojamiento());
        when(estudianteRepository.findAll()).thenReturn(Collections.emptyList());
        alojamientoService.crearNuevaHabitacion(alojamientoDTO);
        verify(notificationService, times(0)).sendNotificationNew(any(), any());
    }
}

 */