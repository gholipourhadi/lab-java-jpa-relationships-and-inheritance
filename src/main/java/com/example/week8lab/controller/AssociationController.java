package com.example.week8lab.controller;

import com.example.week8lab.dto.AssociationDTO;
import com.example.week8lab.model.Association;
import com.example.week8lab.model.Division;
import com.example.week8lab.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associations")
public class AssociationController {

    @Autowired
    private AssociationService associationService;

    @GetMapping
    public ResponseEntity<List<Association>> getAllAssociations() {
        return ResponseEntity.status(HttpStatus.OK).body(associationService.getAllAssociations());
    }

    @PostMapping
    public ResponseEntity<Association> addAssociation(@RequestBody AssociationDTO associationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(associationService.addAssociation(associationDTO));
    }

    @GetMapping("/divisions/district/{district}")
    public ResponseEntity<List<Division>> findDivisionsByDistrict(@PathVariable String district) {
        return ResponseEntity.status(HttpStatus.OK).body(associationService.findDivisionsByDistrict(district));
    }
}
