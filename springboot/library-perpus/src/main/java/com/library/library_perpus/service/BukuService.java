package com.library.library_perpus.service;

import com.library.library_perpus.entity.Buku;
import com.library.library_perpus.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BukuService {

    private final BukuRepository bukuRepository;

    @Autowired
    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public Buku create(Buku buku) {
        return bukuRepository.save(buku);
    }

    public List<Buku> findAll() {
        return bukuRepository.findAll();
    }

    public Optional<Buku> findById(Long id) {
        return bukuRepository.findById(id);
    }

    public Buku update(Long id, Buku dataBaru) {
        Buku bukuLama = bukuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buku dengan id " + id + " tidak ditemukan"));

        bukuLama.setJudul(dataBaru.getJudul());
        bukuLama.setPenulis(dataBaru.getPenulis());
        bukuLama.setPenerbit(dataBaru.getPenerbit());
        bukuLama.setTahunTerbit(dataBaru.getTahunTerbit());
        bukuLama.setIsbn(dataBaru.getIsbn());
        bukuLama.setStok(dataBaru.getStok());

        return bukuRepository.save(bukuLama);
    }

    public void delete(Long id) {
        Buku buku = bukuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buku dengan id " + id + " tidak ditemukan"));
        bukuRepository.delete(buku);
    }
}