package com.library.library_perpus.controller;

import com.library.library_perpus.entity.Anggota;
import com.library.library_perpus.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaController {

    @Autowired
    private AnggotaService anggotaService;

    @PostMapping
    public ResponseEntity<Anggota> create(@RequestBody Anggota anggota) {
        Anggota saved = anggotaService.create(anggota);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Anggota>> getAll() {
        return ResponseEntity.ok(anggotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anggota> getById(@PathVariable Long id) {
        return anggotaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anggota> update(@PathVariable Long id, @RequestBody Anggota anggota) {
        try {
            Anggota updated = anggotaService.update(id, anggota);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            anggotaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}