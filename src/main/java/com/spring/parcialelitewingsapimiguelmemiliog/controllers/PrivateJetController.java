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

    @GetMapping("/")
    public ResponseEntity<?> addJet(@Valid @RequestBody PrivateJetDTO privateJetDTO){
        PrivateJetDTO addedJet = privateJetService.addPrivateJet(privateJetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedJet);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> getJetDetails(@PathVariable Long id){
        Optional<PrivateJetDTO> foundJet = privateJetService.getPrivateJetById(id);
        if(foundJet.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(foundJet);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jet not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJet(@PathVariable Long id, @Valid @RequestBody PrivateJetDTO privateJetDTO){
        Optional<PrivateJetDTO> updatedJet = privateJetService.updatePrivateJet(id, privateJetDTO);
        if(updatedJet.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(updatedJet);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jet not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJet(@PathVariable Long id){
        privateJetService.deletePrivateJet(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Jet deleted successfully");
    }
}
