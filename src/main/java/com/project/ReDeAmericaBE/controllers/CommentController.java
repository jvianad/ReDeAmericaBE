package com.project.ReDeAmericaBE.controllers;

import com.project.ReDeAmericaBE.entities.Comment;
import com.project.ReDeAmericaBE.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @CrossOrigin(origins = "*")
    @PostMapping("/{idUser}/{idPublication}")
    public ResponseEntity<Comment> commentPublication(@PathVariable Integer idUser, @PathVariable Integer idPublication, @RequestBody Comment comment) {
        Comment newComment = commentService.commentPublication(idUser, idPublication, comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
}
