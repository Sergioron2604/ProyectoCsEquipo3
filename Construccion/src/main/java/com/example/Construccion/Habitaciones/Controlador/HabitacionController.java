package com.example.Construccion.Habitaciones.Controlador;

import com.example.Construccion.Habitaciones.Modelo.Habitacion;
import com.example.Construccion.Habitaciones.Servicios.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/v1/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping("/crear")
    public void crearHabitacion(@RequestParam String nombreHabitacion,
                                @RequestParam String descripcion,
                                @RequestParam String direccion,
                                @RequestParam String ciudad,
                                @RequestParam double precio,
                                @RequestParam int idPropietario,
                                @RequestParam int idEstado) {
        habitacionService.crearHabitacion(nombreHabitacion, descripcion, direccion, ciudad, precio, idPropietario, idEstado);
    }

        @DeleteMapping("/borrar/{idHabitacion}")
    public void borrarHabitacion(@PathVariable int idHabitacion) {
        habitacionService.borrarHabitacion(idHabitacion);
    }

    @PutMapping("/{idHabitacion}")
    public void actualizarHabitacion(@PathVariable int idHabitacion,
                                     @RequestParam String nombreHabitacion,
                                     @RequestParam String descripcion,
                                     @RequestParam String direccion,
                                     @RequestParam String ciudad,
                                     @RequestParam double precio,
                                     @RequestParam int idPropietario,
                                     @RequestParam int idEstado) {
        habitacionService.actualizarHabitacion(idHabitacion, nombreHabitacion, descripcion, direccion, ciudad, precio, idPropietario, idEstado);
    }

    @GetMapping("/{idHabitacion}")
    public Habitacion buscarHabitacionPorId(@PathVariable int idHabitacion) {
        return habitacionService.buscarHabitacionPorId(idHabitacion);
    }

    @GetMapping
    public List<Habitacion> findAll() {
        return habitacionService.findAll();
    }

    @PutMapping("/{id}/precio")
    public ResponseEntity<String> cambiarPrecioHabitacion(@PathVariable("id") int idHabitacion, @RequestParam("precio") double nuevoPrecio) {
        try {
            habitacionService.cambiarPrecioHabitacionPorId(idHabitacion, nuevoPrecio);
            return ResponseEntity.ok("Precio de la habitación actualizado correctamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el precio de la habitación");
        }
    }
}
