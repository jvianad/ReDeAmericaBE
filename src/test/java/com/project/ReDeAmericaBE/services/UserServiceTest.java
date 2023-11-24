package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private iUserRepository userRepository;

    @Mock
    private iPublicationRepository publicationRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        // Configuración del mock
        User mockUser = new User(); // Ajusta según tu implementación real
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(mockUser));

        // Llama a la función getUserById
        User resultUser = userService.getUserById(1);

        // Verifica el resultado
        assertEquals(mockUser, resultUser);

        // Verifica que el método del mock fue llamado correctamente
        verify(userRepository).findById(1);
    }

    @Test
    public void testUpdateUser() {
        // Configuración del mock
        User existingUser = new User(); // Ajusta según tu implementación real
        User updatedUser = new User(); // Ajusta según tu implementación real
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        // Llama a la función updateUser
        User resultUser = userService.updateUser(1, updatedUser);

        // Verifica el resultado
        assertEquals(updatedUser, resultUser);

        // Verifica que los métodos del mock fueron llamados correctamente
        verify(userRepository).findById(1);
        verify(userRepository).save(existingUser);
    }

    @Test
    public void testUpdateUserNotFound() {
        // Configuración del mock cuando el usuario no existe
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Llama a la función updateUser
        User resultUser = userService.updateUser(1, new User());

        // Verifica que el resultado es null
        assertNull(resultUser);

        // Verifica que el método del mock fue llamado correctamente
        verify(userRepository).findById(1);
        // No debería haber llamadas a save si el usuario no existe
        verify(userRepository, never()).save(any(User.class));
    }
}