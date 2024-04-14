package com.example.Construccion.UsuariosPropietarios.Controlador;

import com.example.Construccion.UsuariosPropietarios.Modelo.SignInRequest;
import com.example.Construccion.UsuariosPropietarios.Security.JwtResponse;
import com.example.Construccion.UsuariosPropietarios.Servicios.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInRequest data) {
        String token = authService.signin(data.getUsername(), data.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest data) {
        String token = authService.signup(data);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}