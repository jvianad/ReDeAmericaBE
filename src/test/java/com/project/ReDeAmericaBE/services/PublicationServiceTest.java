package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PublicationServiceTest {

    @Mock
    private iPublicationRepository publicationRepository;

    @Mock
    private iUserRepository userRepository;

    @InjectMocks
    private PublicationService publicationService;

    @Test
    public void testCreatePublication() throws IOException {
        User mockUser = new User();
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(mockUser));
        Publication mockPublication = new Publication();
        when(publicationRepository.save(any(Publication.class))).thenReturn(mockPublication);

        Publication resultPublication = publicationService.createPublication(1, new Publication());

        assertNotNull(resultPublication);

        verify(userRepository).findById(1);
        verify(publicationRepository).save(any(Publication.class));
    }

    @Test
    public void testCreatePublicationUserNotFound() {

        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> publicationService.createPublication(1, new Publication()));

        verify(userRepository).findById(1);

        verify(publicationRepository, never()).save(any(Publication.class));
    }

    @Test
    public void testGetAllPublications() {

        Publication mockPublication1 = new Publication();
        Publication mockPublication2 = new Publication();
        when(publicationRepository.findAll()).thenReturn(Arrays.asList(mockPublication1, mockPublication2));

        List<Publication> resultPublications = publicationService.getAllPublications();

        assertEquals(2, resultPublications.size());

        verify(publicationRepository).findAll();
    }

    @Test
    public void testGetAllPublicationsByCountry() {

        Publication mockPublication1 = new Publication();
        Publication mockPublication2 = new Publication();
        when(publicationRepository.findAllByCountry("USA")).thenReturn(Arrays.asList(mockPublication1, mockPublication2));

        List<Publication> resultPublications = publicationService.getAllPublicationsByCountry("USA");

        assertEquals(2, resultPublications.size());

        verify(publicationRepository).findAllByCountry("USA");
    }
}
