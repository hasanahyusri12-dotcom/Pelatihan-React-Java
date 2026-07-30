package tugas.pertemuan5;

import java.util.ArrayList;
import java.util.HashMap;

public class KendaraanService {
    private ArrayList<Kendaraan> daftarKendaraan;
    private HashMap<String, Integer> kategoriKendaraan;

    public KendaraanService() {
        daftarKendaraan = new ArrayList<Kendaraan>();
        kategoriKendaraan = new HashMap<String, Integer>();
        kategoriKendaraan.put("Mobil", 0);
        kategoriKendaraan.put("Motor", 0);
    }

    // Overload 1: tambah Mobil dengan parameter lengkap
    public void tambahKendaraan(String kodeKendaraan, String merk, String warna, double harga, int jumlahPintu) {
        Mobil mobil = new Mobil(kodeKendaraan, merk, warna, harga, jumlahPintu);
        daftarKendaraan.add(mobil);
        kategoriKendaraan.put("Mobil", kategoriKendaraan.get("Mobil") + 1);
        System.out.println("Data mobil berhasil ditambahkan.");
    }

    // Overload 2: tambah Motor dengan parameter lengkap
    public void tambahKendaraan(String kodeKendaraan, String merk, String warna, double harga, String jenisMotor) {
        Motor motor = new Motor(kodeKendaraan, merk, warna, harga, jenisMotor);
        daftarKendaraan.add(motor);
        kategoriKendaraan.put("Motor", kategoriKendaraan.get("Motor") + 1);
        System.out.println("Data motor berhasil ditambahkan.");
    }

    // Overload 3: tambah Motor dengan parameter minimal, warna dan jenis pakai default
    public void tambahKendaraan(String kodeKendaraan, String merk, double harga) {
        tambahKendaraan(kodeKendaraan, merk, "Hitam", harga, "Matic");
    }

    public void lihatSemuaData() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            System.out.println((i + 1) + ". " + k.tampilInfo());
        }
        System.out.println("-----------------------------------");
        tampilkanKategori();
    }

    public void ubahData(String kodeKendaraan, String merkBaru, String warnaBaru, double hargaBaru) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            if (k.getKodeKendaraan().equals(kodeKendaraan)) {
                k.setMerk(merkBaru);
                k.setWarna(warnaBaru);
                k.setHarga(hargaBaru);
                System.out.println("Data kendaraan dengan kode " + kodeKendaraan + " berhasil diubah.");
                return;
            }
        }
        System.out.println("Data dengan kode " + kodeKendaraan + " tidak ditemukan.");
    }

    public void hapusData(String kodeKendaraan) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            if (k.getKodeKendaraan().equals(kodeKendaraan)) {
                if (k instanceof Mobil) {
                    kategoriKendaraan.put("Mobil", kategoriKendaraan.get("Mobil") - 1);
                } else if (k instanceof Motor) {
                    kategoriKendaraan.put("Motor", kategoriKendaraan.get("Motor") - 1);
                }
                daftarKendaraan.remove(i);
                System.out.println("Data kendaraan dengan kode " + kodeKendaraan + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data dengan kode " + kodeKendaraan + " tidak ditemukan.");
    }

    public void tampilkanKategori() {
        System.out.println("Jumlah Mobil: " + kategoriKendaraan.get("Mobil"));
        System.out.println("Jumlah Motor: " + kategoriKendaraan.get("Motor"));
    }

    // Manfaatin interface Perawatan untuk semua kendaraan yang ada di daftar
    public void cekPerawatanSemua() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            if (k instanceof Perawatan) {
                Perawatan p = (Perawatan) k;
                System.out.println(p.jadwalkanServis());
                System.out.println(p.cekKondisi());
            }
        }
    }
}