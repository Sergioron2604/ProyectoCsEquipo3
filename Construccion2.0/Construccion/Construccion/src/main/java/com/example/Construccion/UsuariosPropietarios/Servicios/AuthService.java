package com.example.Construccion.UsuariosPropietarios.Servicios;

import com.example.Construccion.UsuariosPropietarios.Modelo.UserDTO;
import com.example.Construccion.UsuariosPropietarios.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
        }
        return user;
    }

    public String signin(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.createToken(username);
    }

    public String signup(UserDTO userDTO) {
        if (!userRepository.existsByUsername(userDTO.getUsername())) {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername());
        } else {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
    }
}