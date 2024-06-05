package com.example.Construccion.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preferencia_Estudiante")
public class PreferenciaEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia")
    private int idPreferencia;

    @OneToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @Column(name = "presupuesto_maximo", nullable = false)
    private double presupuestoMaximo;

    @Column(name = "desea_roomie", nullable = false)
    private boolean deseaRoomie;

    @Column(name = "desea_lavanderia", nullable = false)
    private boolean deseaLavanderia;

    @Column(name = "necesita_parqueadero_bicicleta", nullable = false)
    private boolean necesitaParqueaderoBicicleta;
}
