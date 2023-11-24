package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.entities.Comment;
import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.repositories.iCommentRepository;
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
public class CommentServiceTest {

    @Mock
    private iCommentRepository commentRepository;

    @Mock
    private iUserRepository userRepository;

    @Mock
    private iPublicationRepository publicationRepository;

    @InjectMocks
    private CommentService commentService;

    @Test
    public void testCommentPublication() {

        User mockUser = new User();
        Publication mockPublication = new Publication();
        Comment mockComment = new Comment();
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(mockUser));
        when(publicationRepository.findById(anyInt())).thenReturn(Optional.of(mockPublication));
        when(commentRepository.save(any(Comment.class))).thenReturn(mockComment);

        Comment resultComment = commentService.commentPublication(1, 2, new Comment());

        assertNotNull(resultComment);

        verify(userRepository).findById(1);
        verify(publicationRepository).findById(2);
        verify(commentRepository).save(any(Comment.class));
    }

    @Test
    public void testCommentPublicationInvalidIds() {

        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());
        when(publicationRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> commentService.commentPublication(1, 2, new Comment()));

        verify(userRepository).findById(1);
        verify(publicationRepository).findById(2);
        verify(commentRepository, never()).save(any(Comment.class));
    }
}
