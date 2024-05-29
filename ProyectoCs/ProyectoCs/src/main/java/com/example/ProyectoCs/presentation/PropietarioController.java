package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.application.dto.FotoDTO;
import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.application.service.AlojamientoService;
import com.example.ProyectoCs.infrastructure.gateway.AlojamientoGateway;
import com.example.ProyectoCs.infrastructure.gateway.FotoGateway;
import com.example.ProyectoCs.application.usecase.PropietarioUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/propietarios")
@Api(tags = "Propietarios", description = "Operaciones relacionadas con propietarios")
public class PropietarioController {

    private final PropietarioUseCase propietarioUseCase;
    private final FotoGateway fotoGateway;
    private final AlojamientoGateway alojamientoGateway;

    @Autowired
    public PropietarioController(PropietarioUseCase propietarioUseCase , FotoGateway fotoGateway ,AlojamientoGateway alojamientoGateway) {
        this.propietarioUseCase = propietarioUseCase;
        this.fotoGateway = fotoGateway;
        this.alojamientoGateway = alojamientoGateway;
    }

    @PostMapping("/registrar")
    @ApiOperation("Registra un nuevo propietario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Propietario registrado exitosamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud debido a datos inválidos o faltantes"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<String> registrarPropietario(@RequestBody PropietarioDTO propietarioDTO) {
        try {
            propietarioUseCase.registrarPropietario(propietarioDTO);
            return ResponseEntity.ok("Propietario registrado exitosamente.");
        } catch (IllegalStateException | IllegalArgumentException | MessagingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/upload")
    @ApiOperation("Sube una foto para un alojamiento específico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Foto subida exitosamente"),
            @ApiResponse(code = 400, message = "Error en la solicitud debido a datos inválidos o faltantes"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<String> uploadFoto(@RequestParam("archivo") MultipartFile archivo,
                                             @RequestParam("idAlojamiento") Integer idAlojamiento) {
        FotoDTO fotoDTO = new FotoDTO();
        fotoDTO.setArchivo(archivo);
        fotoDTO.setIdAlojamiento(idAlojamiento);
        try {
            String url = fotoGateway.uploadFoto(fotoDTO);
            return new ResponseEntity<>(url, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error al subir la foto", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/crearhab")
    @ApiOperation("Crea una nueva habitación en un alojamiento existente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Habitación creada exitosamente"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    public ResponseEntity<String> crearNuevaHabitacion(@RequestBody AlojamientoDTO alojamientoDTO) {
        try {
            alojamientoGateway.crearNuevaHabitacion(alojamientoDTO);
            return ResponseEntity.ok("Habitación creada exitosamente");
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la habitación");
        }
    }
}
