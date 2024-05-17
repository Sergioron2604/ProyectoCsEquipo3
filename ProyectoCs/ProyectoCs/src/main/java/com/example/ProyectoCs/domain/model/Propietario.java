package com.example.ProyectoCs.domain.model;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private long idPropietario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPropietario estadoPropietario;

}
