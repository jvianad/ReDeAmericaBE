package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {
    @Autowired
    private iPublicationRepository publicationRepository;
    @Autowired
    private iUserRepository userRepository;

    public Publication createPublication(Integer idUser, Publication publication) throws IOException {
        Optional<User> optionalUser = userRepository.findById(idUser);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            publication.setUser(user);
            return publicationRepository.save(publication);
        } else {
            throw new RuntimeException("User not found with id: " + idUser);
        }
    }

    public List<Publication> getAllPublications(){
        return publicationRepository.findAll();
    }

    public List<Publication> getAllPublicationsByCountry(String country) {
        return publicationRepository.findAllByCountry(country);
    }
}
