package com.kakofo.kakofoservice.app.controller;


import com.kakofo.kakofoservice.app.entity.PoliceStation;
import com.kakofo.kakofoservice.app.entity.TypePoste;
import com.kakofo.kakofoservice.app.services.PostesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postes")
@AllArgsConstructor
public class PostesController {
    private final PostesService postesService;

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllPostes() {
        return ResponseEntity.ok(postesService.findAll());
    }

   @GetMapping("/findAll/type")
    public ResponseEntity<?> getAllTypePostes() {
        return ResponseEntity.ok(postesService.findAllTypePoste());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PoliceStation policeStation) {
        return ResponseEntity.ok(postesService.save(policeStation));
    }
    @PostMapping("/save/type/poste")
    public ResponseEntity<?> saveTypePoste(@RequestBody TypePoste typePoste) {
        return ResponseEntity.ok(postesService.saveTypePoste(typePoste));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PoliceStation policeStation) {
        return ResponseEntity.ok(postesService.update(policeStation));
    }
}
