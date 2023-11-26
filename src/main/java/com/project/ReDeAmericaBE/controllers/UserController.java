package com.project.ReDeAmericaBE.controllers;

import com.project.ReDeAmericaBE.entities.User;
import com.project.ReDeAmericaBE.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable Integer idUser){
        User user = userService.getUserById(idUser);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userService.getUserByEmail(email);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable Integer idUser, @RequestBody User user){
        User userUpdated = userService.updateUser(idUser, user);
        if (userUpdated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userUpdated);
    }

}
