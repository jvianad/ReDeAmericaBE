package com.project.ReDeAmericaBE.controllers;

import com.project.ReDeAmericaBE.entities.Publication;
import com.project.ReDeAmericaBE.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @PostMapping("/{idUser}")
    public ResponseEntity<Publication> createPublication(@PathVariable Integer idUser, @RequestBody Publication publication) throws IOException {
        Publication newPublication = publicationService.createPublication(idUser, publication);
        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Publication>> getAllPublications(){
        List<Publication> publications = publicationService.getAllPublications();
        if (publications.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(publications);
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<Publication>> getAllPublicationsByCountry(@PathVariable String country){
        List<Publication> publications = publicationService.getAllPublicationsByCountry(country);
        if (publications.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(publications);
    }

    @DeleteMapping("/{idPublication}")
    public ResponseEntity<String> deletePublication(@PathVariable Integer idPublication){
        try{
            publicationService.deletePublication(idPublication);
            return ResponseEntity.ok("La publicación se eliminó correctamente");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
