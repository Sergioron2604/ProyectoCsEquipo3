package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preferencia_Estudiante")
public class PreferenciaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia")
    private Integer idPreferencia;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @Column(name = "tipo_espacio")
    private String tipoEspacio;

    @Column(name = "presupuesto_maximo")
    private Double presupuestoMaximo;

    @Column(name = "distancia_maxima")
    private Double distanciaMaxima;

    @Column(name = "desea_roomie")
    private Boolean deseaRoomie;

    @Column(name = "necesita_parqueadero_bicicleta")
    private Boolean necesitaParqueaderoBicicleta;
}
