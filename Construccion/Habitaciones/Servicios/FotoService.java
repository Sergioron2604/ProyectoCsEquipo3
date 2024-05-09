package com.example.Construccion.Habitaciones.Servicios;

import com.example.Construccion.Habitaciones.Modelo.Foto;
import com.example.Construccion.Habitaciones.Modelo.Habitacion;
import com.example.Construccion.Habitaciones.Repositorio.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    // Lista de extensiones de archivo permitidas
    private final List<String> allowedExtensions = Arrays.asList("jpg", "png", "jpeg", "gif");

    public void SubirFoto(MultipartFile file, int idHabitacion) throws IOException {
        // Validar la extensión del archivo
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new IllegalArgumentException("El archivo no tiene un nombre válido.");
        }
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        if (!allowedExtensions.contains(fileExtension)) {
            throw new IllegalArgumentException("Formato de archivo no admitido. Por favor, sube una imagen en formato JPG, PNG, JPEG o GIF.");
        }

        // Guardar la foto
        String url = guardarImagenEnAlmacenamiento(file);

        // Crear la foto con la URL y la habitación asociada
        Foto foto = new Foto();
        foto.setUrl(url);
        Habitacion habitacion = new Habitacion();
        habitacion.setIdHabitacion(idHabitacion);
        foto.setHabitacion(habitacion);
        fotoRepository.save(foto);
    }

    // Lugar donde se va a guardar la imagen
    private String guardarImagenEnAlmacenamiento(MultipartFile file) throws IOException {
        // Implementa aquí la lógica para guardar la imagen en el almacenamiento
        // Retorna la URL de la imagen guardada
        return "url_de_la_imagen";
    }

    // Para validar las fotos que actualmente esta
    public List<Foto> obtenerTodasLasFotos() {
        return fotoRepository.findAll();
    }

}

