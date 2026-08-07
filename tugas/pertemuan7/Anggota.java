package tugas.pertemuan7;

import java.util.ArrayList;

public class Anggota {
    private String kodeAnggota;
    private String nama;
    private String noTelepon;
    private ArrayList<String> bukuDipinjam;

    public Anggota(String kodeAnggota, String nama, String noTelepon) {
        this.kodeAnggota = kodeAnggota;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.bukuDipinjam = new ArrayList<>();
    }

    public String getKodeAnggota() {
        return kodeAnggota;
    }

    public void setKodeAnggota(String kodeAnggota) {
        this.kodeAnggota = kodeAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public ArrayList<String> getBukuDipinjam() {
        return bukuDipinjam;
    }

    public void tambahPinjaman(String kodeBuku) {
        bukuDipinjam.add(kodeBuku);
    }

    public void hapusPinjaman(String kodeBuku) {
        bukuDipinjam.remove(kodeBuku);
    }

    public void tampilkanInfo() {
        System.out.println(
                kodeAnggota + " | " + nama + " | " + noTelepon + " | Sedang pinjam: " + bukuDipinjam.size() + " buku");
    }
}