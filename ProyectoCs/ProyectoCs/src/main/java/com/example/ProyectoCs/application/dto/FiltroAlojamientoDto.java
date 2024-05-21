package com.example.ProyectoCs.application.dto;

import lombok.Data;

@Data
public class FiltroAlojamientoDto {
    private Double precioMin;
    private Double precioMax;
    private String ciudad;
    private boolean tieneLavanderia;
    private boolean tieneRoomie;
    private boolean tieneParqueaderoBicicleta;

}