package com.kakofo.kakofoservice.app.controller;

import com.kakofo.kakofoservice.app.entity.Infraction;
import com.kakofo.kakofoservice.app.services.InfractionService;
import com.kakofo.kakofoservice.base.response.CResponse;
import com.kakofo.kakofoservice.base.response.PageData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infractions")
@AllArgsConstructor
public class InfractionController {

    private final InfractionService infractionService;

    @GetMapping("/page")
    public CResponse<PageData<Infraction>> findAll(Pageable pageable) {
        return CResponse.success(PageData.fromPage(infractionService.findAll(pageable)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Infraction infraction) {
        return ResponseEntity.ok(infractionService.create(infraction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Infraction infraction) {
        return ResponseEntity.ok(infractionService.update(id, infraction));
    }
}
