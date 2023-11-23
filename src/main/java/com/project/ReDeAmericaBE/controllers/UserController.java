package com.project.ReDeAmericaBE.controllers;

import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("{idUser}/createPublication")
    public ResponseEntity<String> createPublication(@PathVariable("idUser") Integer idUser, @RequestBody Publication publication) {
       try {
           userService.createPublication(idUser, publication);
           return ResponseEntity.ok("Publication created successfully");
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }
}
