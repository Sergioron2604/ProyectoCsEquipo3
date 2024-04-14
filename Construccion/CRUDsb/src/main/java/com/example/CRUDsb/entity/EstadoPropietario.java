package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table(name = "Estado_Propietario")
public class EstadoPropietario {

    @Id
    @Column(name = "id_estado_propietario")
    private Integer idEstadoPropietario;

    @Column(name = "estado_propietario")
    private String estadoPropietario;

    @OneToMany(mappedBy = "estado")
    private Set<Propietario> propietarios;

    // Getters y Setters
}
