package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "Historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @Column(name = "id_entidad_afectada")
    private Integer idEntidadAfectada;

    @Column(name = "tipo_entidad")
    private String tipoEntidad;

    @Column(name = "id_estado_anterior")
    private Integer idEstadoAnterior;

    @Column(name = "id_estado_nuevo")
    private Integer idEstadoNuevo;

    @Column(name = "fecha_hora_cambio")
    private LocalDateTime fechaHoraCambio;
}
