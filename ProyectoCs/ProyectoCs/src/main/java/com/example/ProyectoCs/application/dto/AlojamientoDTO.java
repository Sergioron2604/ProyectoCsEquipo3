package com.example.ProyectoCs.application.dto;

import lombok.Data;

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

    public AlojamientoDTO(int idAlojamiento, String nombreAlojamiento, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstadoHabitacion, int tipoAlojamientoId, boolean tieneLavanderia, boolean tieneRoomie, boolean tieneParqueaderoBicicleta) {
        this.idAlojamiento = idAlojamiento;
        this.nombreAlojamiento = nombreAlojamiento;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.precio = precio;
        this.idPropietario = idPropietario;
        this.idEstadoHabitacion = idEstadoHabitacion;
        this.tipoAlojamientoId = tipoAlojamientoId;
        this.tieneLavanderia = tieneLavanderia;
        this.tieneRoomie = tieneRoomie;
        this.tieneParqueaderoBicicleta = tieneParqueaderoBicicleta;
    }
}