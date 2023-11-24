package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private iPublicationRepository publicationRepository;

    public User getUserById(Integer idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    public User updateUser(Integer idUser, User user) {
        User userUpdated = userRepository.findById(idUser).orElse(null);
        if (userUpdated == null){
            return null;
        }
        userUpdated.setUsername(user.getUsername());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setImage(user.getImage());
        return userRepository.save(userUpdated);
    }
}
