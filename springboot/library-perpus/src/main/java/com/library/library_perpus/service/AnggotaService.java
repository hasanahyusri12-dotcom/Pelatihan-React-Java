package com.library.library_perpus.service;

import com.library.library_perpus.entity.Anggota;
import com.library.library_perpus.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnggotaService {

    @Autowired
    private AnggotaRepository anggotaRepository;

    public Anggota create(Anggota anggota) {
        return anggotaRepository.save(anggota);
    }

    public List<Anggota> findAll() {
        return anggotaRepository.findAll();
    }

    public Optional<Anggota> findById(Long id) {
        return anggotaRepository.findById(id);
    }

    public Anggota update(Long id, Anggota anggotaDetails) {
        Anggota anggota = anggotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anggota tidak ditemukan dengan id: " + id));

        anggota.setNama(anggotaDetails.getNama());
        anggota.setEmail(anggotaDetails.getEmail());
        anggota.setNoTelepon(anggotaDetails.getNoTelepon());
        anggota.setAlamat(anggotaDetails.getAlamat());

        return anggotaRepository.save(anggota);
    }

    public void delete(Long id) {
        Anggota anggota = anggotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anggota tidak ditemukan dengan id: " + id));
        anggotaRepository.delete(anggota);
    }
}