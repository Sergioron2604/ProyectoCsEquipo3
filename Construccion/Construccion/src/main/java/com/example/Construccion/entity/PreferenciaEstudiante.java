package com.example.Construccion.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preferencia_Estudiante")

public class PreferenciaEstudiante {

    @Id
    @Column(name = "id_preferencia")
    private int idPreferencia;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @Column(name = "tipo_espacio")
    private String tipoEspacio;

    @Column(name = "presupuesto_maximo")
    private double presupuestoMaximo;

    @Column(name = "distancia_maxima")
    private double distanciaMaxima;

    @Column(name = "desea_roomie")
    private boolean deseaRoomie;

    @Column(name = "necesita_parqueadero_bicicleta")
    private boolean necesitaParqueaderoBicicleta;
}