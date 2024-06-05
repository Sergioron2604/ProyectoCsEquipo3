package com.springboot.myspringboot.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "preferencias_estudiante")
public class PreferenciasEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia", unique = true, nullable = false)
    private Long idPreferencia;

    @Column(name = "tipo_espacio")
    private String tipoEspacio;

    @Column(name = "presupuesto_maximo", nullable = false)
    private Double presupuestoMaximo;

    @Column(name = "distancia_maxima", nullable = false)
    private Double distanciaMaxima;

    @Column(name = "desea_roomie")
    private Boolean deseaRoomie;

    @Column(name = "necesita_parqueadero_bicicleta")
    private Boolean necesitaParqueaderoBicicleta;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    }
