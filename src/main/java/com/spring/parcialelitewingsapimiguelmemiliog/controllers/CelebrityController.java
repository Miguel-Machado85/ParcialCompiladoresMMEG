package com.spring.parcialelitewingsapimiguelmemiliog.controllers;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.CelebrityDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.services.ICelebrityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/celebrities")
public class CelebrityController {

    @Autowired
    private ICelebrityService celebrityService;

    @PostMapping("/")
    public ResponseEntity<?> registerCelebrity(@Valid @RequestBody CelebrityDTO celebrityDTO) {
        CelebrityDTO celeb = celebrityService.addCelebrity(celebrityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(celeb);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCelebrityById(@PathVariable Long id) {
        Optional<CelebrityDTO> foundCeleb = celebrityService.getCelebrity(id);
        if (foundCeleb.isPresent()) {
            return ResponseEntity.ok(foundCeleb);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Celebrity not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCelebrity(@PathVariable Long id, @Valid @RequestBody CelebrityDTO celebrityDTO) {
        Optional<CelebrityDTO> updatedCeleb = celebrityService.updateCelebrity(id, celebrityDTO);
        if (updatedCeleb.isPresent()) {
            return ResponseEntity.ok(updatedCeleb.get());
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Celebrity not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCelebrity(@PathVariable Long id) {
        celebrityService.deleteCelebrity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Celebrity deleted successfully");
    }
}
