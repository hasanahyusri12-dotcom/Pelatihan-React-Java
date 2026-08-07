package tugas.pertemuan7;

import java.util.ArrayList;
import java.util.HashMap;

public class DataPerpus {
    private ArrayList<Buku> daftarBuku;
    private HashMap<String, Anggota> daftarAnggota;

    public DataPerpus() {
        daftarBuku = new ArrayList<>();
        daftarAnggota = new HashMap<>();
    }

    // ===== CRUD BUKU =====
    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void tampilkanSemuaBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }
        System.out.println("=== DAFTAR BUKU ===");
        for (Buku b : daftarBuku) {
            b.tampilkanInfo();
        }
    }

    // method overloading: tampilkan buku, difilter berdasarkan kategori
    public void tampilkanSemuaBuku(String kategoriFilter) {
        System.out.println("=== DAFTAR BUKU (" + kategoriFilter + ") ===");
        boolean ada = false;
        for (Buku b : daftarBuku) {
            if (b.getKategori().toLowerCase().contains(kategoriFilter.toLowerCase())) {
                b.tampilkanInfo();
                ada = true;
            }
        }
        if (!ada)
            System.out.println("Tidak ada buku dengan kategori tersebut.");
    }

    public Buku cariBuku(String kode) {
        for (Buku b : daftarBuku) {
            if (b.getKode().equalsIgnoreCase(kode))
                return b;
        }
        return null;
    }

    public boolean ubahBuku(String kode, String judulBaru, String pengarangBaru, int stokBaru) {
        Buku b = cariBuku(kode);
        if (b == null)
            return false;
        b.setJudul(judulBaru);
        b.setPengarang(pengarangBaru);
        b.setStok(stokBaru);
        return true;
    }

    public boolean hapusBuku(String kode) {
        Buku b = cariBuku(kode);
        if (b == null)
            return false;
        daftarBuku.remove(b);
        return true;
    }

    // ===== CRUD ANGGOTA =====
    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.put(anggota.getKodeAnggota(), anggota);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public void tampilkanSemuaAnggota() {
        if (daftarAnggota.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }
        System.out.println("=== DAFTAR ANGGOTA ===");
        for (Anggota a : daftarAnggota.values()) {
            a.tampilkanInfo();
        }
    }

    public Anggota cariAnggota(String kode) {
        return daftarAnggota.get(kode);
    }

    public boolean ubahAnggota(String kode, String namaBaru, String teleponBaru) {
        Anggota a = daftarAnggota.get(kode);
        if (a == null)
            return false;
        a.setNama(namaBaru);
        a.setNoTelepon(teleponBaru);
        return true;
    }

    public boolean hapusAnggota(String kode) {
        if (!daftarAnggota.containsKey(kode))
            return false;
        daftarAnggota.remove(kode);
        return true;
    }

    // ===== PEMINJAMAN =====
    public void pinjamBuku(String kodeAnggota, String kodeBuku, int jumlah) {
        Anggota anggota = cariAnggota(kodeAnggota);
        Buku buku = cariBuku(kodeBuku);

        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }
        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        if (buku.pinjam(jumlah)) {
            anggota.tambahPinjaman(buku.getKode());
            System.out.println(anggota.getNama() + " berhasil meminjam \"" + buku.getJudul() + "\".");
        }
    }

    public void kembalikanBuku(String kodeAnggota, String kodeBuku, int jumlah) {
        Anggota anggota = cariAnggota(kodeAnggota);
        Buku buku = cariBuku(kodeBuku);

        if (anggota == null || buku == null) {
            System.out.println("Data anggota atau buku tidak ditemukan.");
            return;
        }

        buku.kembalikan(jumlah);
        anggota.hapusPinjaman(buku.getKode());
        System.out.println("Pengembalian buku berhasil.");
    }
}