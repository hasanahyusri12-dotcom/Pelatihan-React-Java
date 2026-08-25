package com.library.library_perpus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String isbn;

    @NotBlank(message = "Judul buku tidak boleh kosong")
    @Column(nullable = false)
    private String judul;

    private String penerbit;

    @NotBlank(message = "Penulis tidak boleh kosong")
    private String penulis;

    @Min(value = 0, message = "Stok tidak boleh negatif")
    private Integer stok;

    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;
}