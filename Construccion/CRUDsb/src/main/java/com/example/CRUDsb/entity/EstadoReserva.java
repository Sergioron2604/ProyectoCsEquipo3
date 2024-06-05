package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Estado_Reserva")
public class EstadoReserva {

    @Id
    @Column(name = "id_estado_reserva")
    private Integer idEstadoReserva;

    @Column(name = "estado_reserva")
    private String estadoReserva;

    @OneToMany(mappedBy = "estadoReserva")
    private Set<Reserva> reservas;

}
