package com.example.Construccion.Auditoria.Servicios;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class AuditoriaServiceImpl implements AuditoriaRepository {

    private static final String RUTA_ARCHIVO_AUDITORIA = "ruta/a/tu/archivo/auditoria.txt";
    private int contadorErrores = 0;

    @Override
    public void registrarError(String mensaje) {
        contadorErrores++;
        if (contadorErrores >= 2) {
            guardarEnArchivo(mensaje);
            contadorErrores = 0;
        }
    }

    private void guardarEnArchivo(String mensaje) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO_AUDITORIA, true))) {
            writer.println("Error: " + mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
