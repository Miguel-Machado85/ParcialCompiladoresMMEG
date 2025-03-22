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
    public ResponseEntity<CelebrityDTO> registerCelebrity(@Valid @RequestBody CelebrityDTO celebrityDTO) {
        CelebrityDTO celeb = celebrityService.addCelebrity(celebrityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(celeb);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelebrityDTO> getCelebrityById(@PathVariable Long id) {
        Optional<CelebrityDTO> foundCeleb = celebrityService.getCelebrity(id);
        return foundCeleb.map(celebrityDTO -> new ResponseEntity<CelebrityDTO>(celebrityDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<CelebrityDTO>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCelebrity(@PathVariable Long id, @Valid @RequestBody CelebrityDTO celebrityDTO) {
        Optional<CelebrityDTO> updatedCeleb = celebrityService.updateCelebrity(id, celebrityDTO);
        return updatedCeleb.map(celebrityDTO1 -> new ResponseEntity<CelebrityDTO>(celebrityDTO1, HttpStatus.OK))
                .orElse(new ResponseEntity<CelebrityDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CelebrityDTO> removeCelebrity(@PathVariable Long id) {
        celebrityService.deleteCelebrity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
