package com.project.ReDeAmericaBE.config.Auth;

import com.project.ReDeAmericaBE.config.JWT.JwtService;
import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private iUserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    public void setUp() {
        // Configura el comportamiento esperado de los mocks
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(new User()));
        when(jwtService.getToken(any())).thenReturn("mockedToken");
    }

    @Test
    public void testLogin() {
        // Crea un objeto LoginRequest
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("correo@ejemplo.com");
        loginRequest.setPassword("contraseña");

        // Llama a la función login
        AuthResponse authResponse = authService.login(loginRequest);

        // Verifica el resultado
        assertEquals("mockedToken", authResponse.getToken());

        // Verifica que los métodos de los mocks fueron llamados correctamente
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository).findByEmail("correo@ejemplo.com");
        verify(jwtService).getToken(any());
    }
}
