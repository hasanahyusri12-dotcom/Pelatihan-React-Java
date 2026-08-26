package com.library.library_perpus.controller;

import com.library.library_perpus.entity.Buku;
import com.library.library_perpus.service.BukuService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @PostMapping
    public ResponseEntity<Buku> create(@Valid @RequestBody Buku buku) {
        Buku saved = bukuService.create(buku);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Buku>> getAll() {
        return ResponseEntity.ok(bukuService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buku> getById(@PathVariable Long id) {
        return bukuService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buku> update(@PathVariable Long id, @Valid @RequestBody Buku buku) {
        try {
            Buku updated = bukuService.update(id, buku);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            bukuService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}