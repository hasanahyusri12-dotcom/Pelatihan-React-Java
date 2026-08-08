package uts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;

public class KelolaPerpustakaan {
    private ArrayList<DataBuku> daftarBuku;
    private ArrayList<Anggota> daftarAnggota;
    private ArrayList<StafPerpus> daftarStaf;
    private HashMap<String, TransaksiPeminjaman> daftarTransaksi; 
    private int batasPeminjaman; 
    private int dendaPerHari;   

    private Scanner inputan;
    private int nomorTransaksi;

    public KelolaPerpustakaan(Scanner inputan) {
        this.inputan = inputan;
        this.daftarBuku = new ArrayList<>();
        this.daftarAnggota = new ArrayList<>();
        this.daftarStaf = new ArrayList<>();
        this.daftarTransaksi = new HashMap<>();
        this.batasPeminjaman = 7;   
        this.dendaPerHari = 20000;   
        this.nomorTransaksi = 1;
    }

    public int getBatasPeminjaman() {
        return batasPeminjaman;
    }

    public void setBatasPeminjaman(int batasPeminjaman) {
        this.batasPeminjaman = batasPeminjaman;
    }

    public int getDendaPerHari() {
        return dendaPerHari;
    }

    public void setDendaPerHari(int dendaPerHari) {
        this.dendaPerHari = dendaPerHari;
    }

    private int inputTahun(String label) {
        int tahun;
        while (true) {
            System.out.print(label);
            String input = inputan.nextLine().trim();
            try {
                tahun = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka! Coba lagi.");
                continue;
            }
            if (tahun < 1000 || tahun > LocalDate.now().getYear()) {
                System.out.println("Tahun terbit tidak masuk akal! Coba lagi.");
                continue;
            }
            break;
        }
        return tahun;
    }

    private String inputKode(String label) {
        System.out.print(label);
        return inputan.nextLine().trim().toUpperCase();
    }

    // ---------- CRUD BUKU ----------
    public void tambahBuku() {
        System.out.println("~ ~ ~ Tambah Buku ~ ~ ~");
        String kode = inputKode("Kode Buku: ");
        if (kode.isEmpty()) {
            System.out.println("Kode buku tidak boleh kosong!");
            return;
        }
        if (cariBuku(kode) != null) {
            System.out.println("Kode buku sudah digunakan!");
            return;
        }

        System.out.print("Judul: ");
        String judul = inputan.nextLine().trim();
        if (judul.isEmpty()) {
            System.out.println("Judul tidak boleh kosong!");
            return;
        }

        System.out.print("Penulis: ");
        String penulis = inputan.nextLine().trim();
        if (penulis.isEmpty()) {
            System.out.println("Penulis tidak boleh kosong!");
            return;
        }

        System.out.print("Kategori: ");
        String kategori = inputan.nextLine().trim();
        if (kategori.isEmpty()) {
            System.out.println("Kategori tidak boleh kosong!");
            return;
        }

        int tahun = inputTahun("Tahun Terbit: ");

        daftarBuku.add(new DataBuku(kode, judul, penulis, kategori, tahun));
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void tampilkanBuku() {
        System.out.println("~ ~ ~ Daftar Buku ~ ~ ~");
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }
        for (DataBuku buku : daftarBuku) {
            buku.tampilkanData();
        }
    }

    public void ubahBuku() {
        System.out.println("~ ~ ~ Ubah Buku ~ ~ ~");
        String kode = inputKode("Masukkan kode buku yang ingin diubah: ");
        DataBuku buku = cariBuku(kode);
        if (buku == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }

        System.out.print("Judul baru (" + buku.getJudul() + "), kosongkan jika tidak diubah: ");
        String judul = inputan.nextLine().trim();
        if (!judul.isEmpty()) {
            buku.setJudul(judul);
        }

        System.out.print("Penulis baru (" + buku.getPenulis() + "): ");
        String penulis = inputan.nextLine().trim();
        if (!penulis.isEmpty()) {
            buku.setPenulis(penulis);
        }

        System.out.print("Kategori baru (" + buku.getKategori() + "): ");
        String kategori = inputan.nextLine().trim();
        if (!kategori.isEmpty()) {
            buku.setKategori(kategori);
        }

        System.out.print("Ubah tahun terbit? (y/n): ");
        String pilih = inputan.nextLine().trim();
        if (pilih.equalsIgnoreCase("y")) {
            int tahun = inputTahun("Tahun Terbit baru: ");
            buku.setTahunTerbit(tahun);
        }

        System.out.println("Data buku berhasil diubah.");
    }

    public void hapusBuku() {
        System.out.println("~ ~ ~ Hapus Buku ~ ~ ~");
        String kode = inputKode("Masukkan kode buku yang ingin dihapus: ");
        DataBuku buku = cariBuku(kode);
        if (buku == null) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }
        if (!buku.isTersedia()) {
            System.out.println("Buku sedang dipinjam, tidak dapat dihapus!");
            return;
        }
        daftarBuku.remove(buku);
        System.out.println("Buku berhasil dihapus.");
    }

    // ---------- CRUD ANGGOTA ----------
    public void tambahAnggota() {
        System.out.println("=== Tambah Anggota ===");
        String id = inputKode("ID Anggota: ");
        if (id.isEmpty()) {
            System.out.println("ID anggota tidak boleh kosong!");
            return;
        }
        if (cariAnggota(id) != null) {
            System.out.println("ID anggota sudah digunakan!");
            return;
        }
        System.out.print("Nama: ");
        String nama = inputan.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong!");
            return;
        }
        System.out.print("Alamat: ");
        String alamat = inputan.nextLine().trim();
        System.out.print("No. Telepon: ");
        String noTelepon = inputan.nextLine().trim();
        String idKartu = inputKode("ID Kartu: ");

        daftarAnggota.add(new Anggota(id, nama, alamat, noTelepon, idKartu));
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public void tampilkanAnggota() {
        System.out.println("=== Daftar Anggota ===");
        if (daftarAnggota.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }
        for (Anggota anggota : daftarAnggota) {
            anggota.tampilkanInfo();
        }
    }

    public void ubahAnggota() {
        System.out.println("=== Ubah Anggota ===");
        String id = inputKode("Masukkan ID anggota yang ingin diubah: ");
        Anggota anggota = cariAnggota(id);
        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan!");
            return;
        }

        System.out.print("Nama baru (" + anggota.getNama() + "), kosongkan jika tidak diubah: ");
        String nama = inputan.nextLine().trim();
        if (!nama.isEmpty()) {
            anggota.setNama(nama);
        }

        System.out.print("Alamat baru (" + anggota.getAlamat() + "): ");
        String alamat = inputan.nextLine().trim();
        if (!alamat.isEmpty()) {
            anggota.setAlamat(alamat);
        }

        System.out.print("No. Telepon baru (" + anggota.getNoTelepon() + "): ");
        String noTelepon = inputan.nextLine().trim();
        if (!noTelepon.isEmpty()) {
            anggota.setNoTelepon(noTelepon);
        }

        System.out.print("Ubah status aktif? (y/n): ");
        String pilih = inputan.nextLine().trim();
        if (pilih.equalsIgnoreCase("y")) {
            anggota.setAktif(!anggota.isAktif());
        }

        System.out.println("Data anggota berhasil diubah.");
    }

    public void hapusAnggota() {
        System.out.println("=== Hapus Anggota ===");
        String id = inputKode("Masukkan ID anggota yang ingin dihapus: ");
        Anggota anggota = cariAnggota(id);
        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan!");
            return;
        }
        for (TransaksiPeminjaman transaksi : daftarTransaksi.values()) {
            if (transaksi.getAnggota() == anggota && !transaksi.isSudahDikembalikan()) {
                System.out.println("Anggota masih memiliki peminjaman aktif, tidak dapat dihapus!");
                return;
            }
        }
        daftarAnggota.remove(anggota);
        System.out.println("Anggota berhasil dihapus.");
    }

    // ---------- CRUD STAF ----------
    public void tambahStaf() {
        System.out.println("=== Tambah Staf ===");
        String id = inputKode("ID Staf: ");
        if (id.isEmpty()) {
            System.out.println("ID staf tidak boleh kosong!");
            return;
        }
        if (cariStaf(id) != null) {
            System.out.println("ID staf sudah digunakan!");
            return;
        }
        System.out.print("Nama: ");
        String nama = inputan.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong!");
            return;
        }
        System.out.print("Alamat: ");
        String alamat = inputan.nextLine().trim();
        System.out.print("No. Telepon: ");
        String noTelepon = inputan.nextLine().trim();
        System.out.print("Jabatan: ");
        String jabatan = inputan.nextLine().trim();
        if (jabatan.isEmpty()) {
            System.out.println("Jabatan tidak boleh kosong!");
            return;
        }

        daftarStaf.add(new StafPerpus(id, nama, alamat, noTelepon, jabatan));
        System.out.println("Staf berhasil ditambahkan.");
    }

    public void tampilkanStaf() {
        System.out.println("=== Daftar Staf ===");
        if (daftarStaf.isEmpty()) {
            System.out.println("Belum ada data staf.");
            return;
        }
        for (StafPerpus staf : daftarStaf) {
            staf.tampilkanInfo();
        }
    }

    public StafPerpus cariStaf(String id) {
        for (StafPerpus staf : daftarStaf) {
            if (staf.getId().equalsIgnoreCase(id)) {
                return staf;
            }
        }
        return null;
    }

    // ---------- PEMINJAMAN & PENGEMBALIAN ----------
    public void pinjamBuku() {
        System.out.println("* * * Peminjaman Buku * * *");
        String idAnggota = inputKode("ID Anggota: ");
        Anggota anggota = cariAnggota(idAnggota);
        if (anggota == null) {
            System.out.println("Anggota tidak terdaftar!");
            return;
        }
        if (!anggota.isAktif()) {
            System.out.println("Anggota berstatus nonaktif, tidak dapat meminjam!");
            return;
        }

        String kodeBuku = inputKode("Kode Buku: ");
        DataBuku buku = cariBuku(kodeBuku);
        if (buku == null) {
            System.out.println("Buku tidak terdaftar!");
            return;
        }

        if (!buku.isTersedia()) {
            System.out.println("Buku sedang dipinjam, tidak dapat dipinjam kembali!");
            return;
        }

        String kodeTransaksi = "TRS" + nomorTransaksi;
        nomorTransaksi++;

        TransaksiPeminjaman transaksi = new TransaksiPeminjaman(kodeTransaksi, anggota, buku, LocalDate.now());
        daftarTransaksi.put(kodeTransaksi, transaksi);

        buku.pinjam();

        System.out.println("Peminjaman berhasil. Kode transaksi: " + kodeTransaksi);
    }

    public void kembalikanBuku() {
        System.out.println("* * * Pengembalian Buku * * *");
        String kodeTransaksi = inputKode("Kode Transaksi: ");

        TransaksiPeminjaman transaksi = daftarTransaksi.get(kodeTransaksi);
        if (transaksi == null) {
            System.out.println("Kode transaksi tidak ditemukan!");
            return;
        }
        if (transaksi.isSudahDikembalikan()) {
            System.out.println("Transaksi ini sudah selesai sebelumnya!");
            return;
        }

        DataBuku buku = transaksi.getBuku();
        if (buku.isTersedia()) {
            System.out.println("Data tidak konsisten, buku tidak sedang dipinjam!");
            return;
        }

        transaksi.prosesPengembalian(LocalDate.now(), batasPeminjaman, dendaPerHari);
        buku.kembalikan();

        System.out.println("Buku berhasil dikembalikan.");
        System.out.println("Lama peminjaman: " + transaksi.getLamaPeminjaman() + " hari");
        if (transaksi.getDenda() > 0) {
            System.out.println("Terlambat " + transaksi.getKeterlambatan() + " hari, denda: Rp" + transaksi.getDenda());
        } else {
            System.out.println("Tidak ada keterlambatan.");
        }
    }

    // ---------- PENCARIAN ----------
    public DataBuku cariBuku(String kode) {
        for (DataBuku buku : daftarBuku) {
            if (buku.getKodeBuku().equalsIgnoreCase(kode)) {
                return buku;
            }
        }
        return null;
    }

    public void cariBuku(String keyword, String kategori) {
        System.out.println("* * * Hasil Pencarian Buku * * *");
        boolean ditemukan = false;
        for (DataBuku buku : daftarBuku) {
            boolean cocokJudul = buku.getJudul().toLowerCase().contains(keyword.toLowerCase());
            boolean cocokKategori = kategori.isEmpty() || buku.getKategori().equalsIgnoreCase(kategori);
            if (cocokJudul && cocokKategori) {
                buku.tampilkanData();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public Anggota cariAnggota(String idAtauNama) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getId().equalsIgnoreCase(idAtauNama) || anggota.getNama().equalsIgnoreCase(idAtauNama)) {
                return anggota;
            }
        }
        return null;
    }

    public void menuPencarian() {
        System.out.println("# # # Menu Pencarian # # #");
        System.out.println("1. Cari Buku (Kode)");
        System.out.println("2. Cari Buku (Judul & Kategori)");
        System.out.println("3. Cari Anggota (ID/Nama)");
        System.out.print("Pilih: ");
        String pilihan = inputan.nextLine().trim();

        switch (pilihan) {
            case "1":
                String kode = inputKode("Kode Buku: ");
                DataBuku hasilBuku = cariBuku(kode);
                if (hasilBuku != null) {
                    hasilBuku.tampilkanData();
                } else {
                    System.out.println("Buku tidak ditemukan.");
                }
                break;
            case "2":
                System.out.print("Kata kunci judul: ");
                String keyword = inputan.nextLine().trim();
                System.out.print("Kategori (kosongkan jika semua): ");
                String kategori = inputan.nextLine().trim();
                cariBuku(keyword, kategori);
                break;
            case "3":
                System.out.print("ID atau Nama Anggota: ");
                String idNama = inputan.nextLine().trim();
                Anggota anggota = cariAnggota(idNama);
                if (anggota != null) {
                    anggota.tampilkanInfo();
                } else {
                    System.out.println("Anggota tidak ditemukan.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    // ---------- TRANSAKSI ----------
    public void lihatTransaksi() {
        System.out.println("# # # Daftar Transaksi # # #");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (TransaksiPeminjaman transaksi : daftarTransaksi.values()) {
            transaksi.tampilkanData();
        }
    }
}