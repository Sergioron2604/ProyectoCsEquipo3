package com.example.ProyectoCs.application.dto;

import lombok.Data;

@Data
public class PropietarioDTO {
    private int idPropietario;
    private String nombre;
    private String email;
    private String telefono;
    private int idEstadoPropietario;
}
