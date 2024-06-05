package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "Propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Integer idPropietario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPropietario estado;

    @OneToMany(mappedBy = "propietario")
    private Set<Habitacion> habitaciones;


}
