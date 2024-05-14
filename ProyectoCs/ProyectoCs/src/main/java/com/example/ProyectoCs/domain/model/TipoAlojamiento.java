package com.example.ProyectoCs.domain.model;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "TipoAlojamiento")
public class TipoAlojamiento {

    @Id
    @Column(name = "TipoAlojamientoID")
    private int tipoAlojamientoID;

    @Column(name = "NombreTipoAlojamiento", nullable = false, length = 50)
    private String nombreTipoAlojamiento;

}
