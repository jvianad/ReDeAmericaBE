package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.Comment;
import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iCommentRepository;
import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private iCommentRepository commentRepository;
    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private iPublicationRepository publicationRepository;

    public Comment commentPublication(Integer idUser, Integer idPublication, Comment comment) {
        Optional<User> usuarioOptional = userRepository.findById(idUser);
        Optional<Publication> publicacionOptional = publicationRepository.findById(idPublication);

        if (usuarioOptional.isPresent() && publicacionOptional.isPresent()) {
            User user = usuarioOptional.get();
            Publication publication = publicacionOptional.get();

            comment.setUser(user);
            comment.setPublication(publication);

            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("Id or Publication do not exist");
        }
    }
}
