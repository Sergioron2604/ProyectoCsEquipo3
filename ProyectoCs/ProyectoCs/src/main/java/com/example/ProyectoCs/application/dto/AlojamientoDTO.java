package com.example.ProyectoCs.application.dto;

import lombok.Data;

@Data
public class AlojamientoDTO {
    private int idAlojamiento;
    private String nombreAlojamiento;
    private String descripcion;
    private String direccion;
    private String ciudad;
    private double precio;
    private int idPropietario;
    private int idEstadoHabitacion;
    private int tipoAlojamientoId;
    private boolean tieneLavanderia;
    private boolean tieneRoomie;
    private boolean tieneParqueaderoBicicleta;
}
