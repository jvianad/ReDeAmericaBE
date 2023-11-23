package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private iUserRepository userRepository;

    @Autowired
    private iPublicationRepository publicationRepository;

    public void createPublication(Integer userId, Publication publication) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            publication.setUser(user);
            user.getPublications().add(publication);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
}
