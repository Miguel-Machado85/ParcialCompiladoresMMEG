package com.spring.parcialelitewingsapimiguelmemiliog.controllers;

import com.spring.parcialelitewingsapimiguelmemiliog.dto.PrivateJetDTO;
import com.spring.parcialelitewingsapimiguelmemiliog.services.IPrivateJetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jets")
public class PrivateJetController {

    @Autowired
    private IPrivateJetService privateJetService;

    @PostMapping("/")
    public ResponseEntity<PrivateJetDTO> addJet(@Valid @RequestBody PrivateJetDTO privateJetDTO){
        PrivateJetDTO addedJet = privateJetService.addPrivateJet(privateJetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedJet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrivateJetDTO> getJetDetails(@PathVariable Long id){
        Optional<PrivateJetDTO> foundJet = privateJetService.getPrivateJetById(id);
        return foundJet.map(privateJetDTO -> new ResponseEntity<PrivateJetDTO>(privateJetDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<PrivateJetDTO>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrivateJetDTO> updateJet(@PathVariable Long id, @Valid @RequestBody PrivateJetDTO privateJetDTO){
        Optional<PrivateJetDTO> updatedJet = privateJetService.updatePrivateJet(id, privateJetDTO);
        return updatedJet.map(privateJetDTO1 -> new ResponseEntity<PrivateJetDTO>(privateJetDTO1, HttpStatus.OK))
                .orElse(new ResponseEntity<PrivateJetDTO>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PrivateJetDTO> deleteJet(@PathVariable Long id){
        privateJetService.deletePrivateJet(id);
        return new ResponseEntity<PrivateJetDTO>(HttpStatus.NO_CONTENT);
    }
}
