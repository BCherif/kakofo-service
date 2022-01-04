package com.kakofo.kakofoservice.controller;


import com.kakofo.kakofoservice.app.entity.PoliceStation;
import com.kakofo.kakofoservice.services.PostesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postes")
@AllArgsConstructor
public class PostesController {
    private final PostesService postesService;

    @GetMapping
    public ResponseEntity<?> getAllPostes() {
        return ResponseEntity.ok(postesService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PoliceStation policeStation) {
        return ResponseEntity.ok(postesService.save(policeStation));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PoliceStation policeStation) {
        return ResponseEntity.ok(postesService.update(policeStation));
    }
}
