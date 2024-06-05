package com.example.Construccion.Historial.Modelo;
import com.example.Construccion.Habitaciones.Modelo.EstadoHabitacion;
import com.example.Construccion.UsuariosPropietarios.Modelo.EstadoEstudiante;
import com.example.Construccion.UsuariosPropietarios.Modelo.EstadoPropietario;
import com.example.Construccion.Commons.entity.EstadoReserva;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "Historial")

public class Historial {

    @Id
    @Column(name = "id_historial")
    private int idHistorial;

    @Column(name = "id_entidad_afectada")
    private int idEntidadAfectada;

    @Column(name = "tipo_entidad")
    private String tipoEntidad;

    @Column(name = "id_estado_anterior")
    private int idEstadoAnterior;

    @Column(name = "id_estado_nuevo")
    private int idEstadoNuevo;

    @Column(name = "fecha_hora_cambio")
    private Date fechaHoraCambio;

    @ManyToOne
    @JoinColumn(name = "id_estado_anterior", referencedColumnName = "id_estado_habitacion", insertable = false, updatable = false)
    private EstadoHabitacion estadoHabitacionAnterior;

    @ManyToOne
    @JoinColumn(name = "id_estado_nuevo", referencedColumnName = "id_estado_habitacion", insertable = false, updatable = false)
    private EstadoHabitacion estadoHabitacionNuevo;

    @ManyToOne
    @JoinColumn(name = "id_estado_anterior", referencedColumnName = "id_estado_reserva", insertable = false, updatable = false)
    private EstadoReserva estadoReservaAnterior;

    @ManyToOne
    @JoinColumn(name = "id_estado_nuevo", referencedColumnName = "id_estado_reserva", insertable = false, updatable = false)
    private EstadoReserva estadoReservaNuevo;

    @ManyToOne
    @JoinColumn(name = "id_estado_anterior", referencedColumnName = "id_estado_estudiante", insertable = false, updatable = false)
    private EstadoEstudiante estadoEstudianteAnterior;

    @ManyToOne
    @JoinColumn(name = "id_estado_nuevo", referencedColumnName = "id_estado_estudiante", insertable = false, updatable = false)
    private EstadoEstudiante estadoEstudianteNuevo;

    @ManyToOne
    @JoinColumn(name = "id_estado_anterior", referencedColumnName = "id_estado_propietario", insertable = false, updatable = false)
    private EstadoPropietario estadoPropietarioAnterior;

    @ManyToOne
    @JoinColumn(name = "id_estado_nuevo", referencedColumnName = "id_estado_propietario", insertable = false, updatable = false)
    private EstadoPropietario estadoPropietarioNuevo;
}