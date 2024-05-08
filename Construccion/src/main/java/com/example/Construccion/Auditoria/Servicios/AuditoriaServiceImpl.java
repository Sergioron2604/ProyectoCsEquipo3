package com.example.Construccion.Auditoria.Servicios;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Service
public class AuditoriaServiceImpl {

    private static final String RUTA_ARCHIVO_AUDITORIA = "C:\\Users\\pipe2\\Desktop\\Trabajo\\auditoria.txt";
    private static final int NUMERO_ERRORES_PARA_REGISTRAR = 3;
    private int contadorErrores = 0;

    public void registrarError(String mensaje) {
        contadorErrores++;
        if (contadorErrores >= NUMERO_ERRORES_PARA_REGISTRAR) {
            guardarEnArchivo("Error: " + mensaje);
            contadorErrores = 0;
        }
    }

    private void guardarEnArchivo(String mensaje) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO_AUDITORIA, true))) {
            writer.println("Fecha: " + new Date());
            writer.println(mensaje);
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}