package com.example.Construccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.example.Construccion.Auditoria.Modelo",
		"com.example.Construccion.Commons.Modelo",
		"com.example.Construccion.Habitaciones.Modelo",
		"com.example.Construccion.Persistencia.Modelo",
		"com.example.Construccion.PreferenciaEstudiante.Modelo",
		"com.example.Construccion.Seguridad.Modelo",
		"com.example.Construccion.UniversidadAmenidad.Modelo",
		"com.example.Construccion.UsuarioPropietarios.Modelo"
})
public class ConstruccionApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConstruccionApplication.class, args);
	}
}