package com.library.library_perpus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "anggota")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anggota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama tidak boleh kosong")
    @Column(nullable = false)
    private String nama;

    @Email(message = "Format email tidak valid")
    @Column(unique = true)
    private String email;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "tanggal_daftar")
    private LocalDate tanggalDaftar;

    private String alamat;

    @Column(name = "no_telepon")
    private String noTelepon;
}