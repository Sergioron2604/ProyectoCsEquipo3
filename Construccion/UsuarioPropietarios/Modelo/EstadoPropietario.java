package com.example.Construccion.UsuarioPropietarios.Modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table(name = "Estado_Propietario")

public class EstadoPropietario {

    @Id
    @Column(name = "id_estado_propietario")
    private int idEstadoPropietario;

    @Column(name = "estado_propietario")
    private String estadoPropietario;

    @OneToMany(mappedBy = "estadoPropietario")
    private Set<Propietario> propietarios;
}
