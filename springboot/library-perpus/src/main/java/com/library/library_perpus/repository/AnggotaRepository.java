package com.library.library_perpus.repository;

import com.library.library_perpus.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Long> {
}