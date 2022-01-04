package com.kakofo.kakofoservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postes")
@AllArgsConstructor
public class PostesController {
    //private final AffectionCandidatPartiService affectionCandidatPartiService;

//    @GetMapping
//    public ResponseEntity<?> getCandidatPartis() {
//        return ResponseEntity.ok(affectionCandidatPartiService.getCandidatPartis());
//    }

//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody AffectionCandidatParti affectionCandidatParti) {
//        return ResponseEntity.ok(affectionCandidatPartiService.create(affectionCandidatParti));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AffectionCandidatParti affectionCandidatParti) {
//        return ResponseEntity.ok(affectionCandidatPartiService.update(id, affectionCandidatParti));
//    }
}
