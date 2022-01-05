package com.kakofo.kakofoservice.app.controller;


import com.kakofo.kakofoservice.app.entity.Corridor;
import com.kakofo.kakofoservice.app.services.CorridorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corridor")
@AllArgsConstructor
public class CorridorController {
    private final CorridorService corridorService;

    @GetMapping
    public ResponseEntity<?> getAllCorridor() {
        return ResponseEntity.ok(corridorService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Corridor corridor) {
        return ResponseEntity.ok(corridorService.save(corridor));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Corridor corridor) {
        return ResponseEntity.ok(corridorService.update(corridor));
    }
}
