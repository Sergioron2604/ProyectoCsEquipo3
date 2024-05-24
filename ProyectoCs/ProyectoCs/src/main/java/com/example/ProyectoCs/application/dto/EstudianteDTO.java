package com.example.ProyectoCs.application.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class EstudianteDTO {
    private UUID idEstudiante;
    private String nombre;
    private int edad;
    private String email;
    private String contraseña;
    private String telefono;
    private int idUniversidad;
    private int idEstadoEstudiante;
}
