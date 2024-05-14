package com.example.ProyectoCs.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Estado_Propietario")
public class EstadoPropietario {

    @Id
    @Column(name = "id_estado_propietario")
    private int idEstadoPropietario;

    @Column(name = "estado_propietario")
    private String estadoPropietario;
}
