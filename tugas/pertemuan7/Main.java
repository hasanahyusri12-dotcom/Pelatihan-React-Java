package tugas.pertemuan7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Inputan = new Scanner(System.in);
        DataPerpus perpus = new DataPerpus();
        isiDataAwal(perpus); // data contoh biar tidak kosong pas testing

        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = inputInt(Inputan);

            switch (pilihan) {
                case 1: menuTambahBuku(Inputan, perpus); break;
                case 2: perpus.tampilkanSemuaBuku(); break;
                case 3: menuUbahBuku(Inputan, perpus); break;
                case 4: menuHapusBuku(Inputan, perpus); break;
                case 5: menuTambahAnggota(Inputan, perpus); break;
                case 6: perpus.tampilkanSemuaAnggota(); break;
                case 7: menuUbahAnggota(Inputan, perpus); break;
                case 8: menuHapusAnggota(Inputan, perpus); break;
                case 9: menuPinjamBuku(Inputan, perpus); break;
                case 10: menuKembalikanBuku(Inputan, perpus); break;
                case 11: menuCariBerdasarkanKategori(Inputan, perpus); break;
                case 0: System.out.println("Terima kasih, program selesai."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (pilihan != 0);

        Inputan.close();
    }

    static void tampilkanMenu() {
        System.out.println("===== SISTEM MANAJEMEN PERPUSTAKAAN =====");
        System.out.println("1.  Tambah Buku");
        System.out.println("2.  Tampilkan Semua Buku");
        System.out.println("3.  Ubah Data Buku");
        System.out.println("4.  Hapus Buku");
        System.out.println("5.  Tambah Anggota");
        System.out.println("6.  Tampilkan Semua Anggota");
        System.out.println("7.  Ubah Data Anggota");
        System.out.println("8.  Hapus Anggota");
        System.out.println("9.  Pinjam Buku");
        System.out.println("10. Kembalikan Buku");
        System.out.println("11. Cari Buku Berdasarkan Kategori");
        System.out.println("0.  Keluar");
    }

    static void menuTambahBuku(Scanner inputBuku, DataPerpus perpus) {
        System.out.print("Kode buku: ");
        String kode = inputBuku.nextLine();
        System.out.print("Judul: ");
        String judul = inputBuku.nextLine();
        System.out.print("Pengarang: ");
        String pengarang = inputBuku.nextLine();
        System.out.print("Stok: ");
        int stok = inputInt(inputBuku);

        System.out.print("Jenis buku (1=Fiksi, 2=Non-Fiksi): ");
        int jenis = inputInt(inputBuku);

        if (jenis == 1) {
            System.out.print("Genre: ");
            String genre = inputBuku.nextLine();
            perpus.tambahBuku(new BukuJenisFiksi(kode, judul, pengarang, stok, genre));
        } else if (jenis == 2) {
            System.out.print("Subjek: ");
            String subjek = inputBuku.nextLine();
            perpus.tambahBuku(new JenisBukuNonFiksi(kode, judul, pengarang, stok, subjek));
        } else {
            System.out.println("Jenis tidak valid, buku tidak ditambahkan.");
        }
    }

    static void menuUbahBuku(Scanner inputBuku, DataPerpus perpus) {
        System.out.print("Kode buku yang diubah: ");
        String kode = inputBuku.nextLine();
        System.out.print("Judul baru: ");
        String judul = inputBuku.nextLine();
        System.out.print("Pengarang baru: ");
        String pengarang = inputBuku.nextLine();
        System.out.print("Stok baru: ");
        int stok = inputInt(inputBuku);

        boolean berhasil = perpus.ubahBuku(kode, judul, pengarang, stok);
        System.out.println(berhasil ? "Data buku berhasil diubah." : "Buku tidak ditemukan.");
    }

    static void menuHapusBuku(Scanner inputBuku, DataPerpus perpus) {
        System.out.print("Kode buku yang dihapus: ");
        String kode = inputBuku.nextLine();
        boolean berhasil = perpus.hapusBuku(kode);
        System.out.println(berhasil ? "Buku berhasil dihapus." : "Buku tidak ditemukan.");
    }

    static void menuTambahAnggota(Scanner inputAnggota, DataPerpus perpus) {
        System.out.print("Kode anggota: ");
        String kode = inputAnggota.nextLine();
        System.out.print("Nama: ");
        String nama = inputAnggota.nextLine();
        System.out.print("No telepon: ");
        String telepon = inputAnggota.nextLine();
        perpus.tambahAnggota(new Anggota(kode, nama, telepon));
    }

    static void menuUbahAnggota(Scanner inputAnggota, DataPerpus perpus) {
        System.out.print("Kode anggota yang diubah: ");
        String kode = inputAnggota.nextLine();
        System.out.print("Nama baru: ");
        String nama = inputAnggota.nextLine();
        System.out.print("No telepon baru: ");
        String telepon = inputAnggota.nextLine();
        boolean berhasil = perpus.ubahAnggota(kode, nama, telepon);
        System.out.println(berhasil ? "Data anggota berhasil diubah." : "Anggota tidak ditemukan.");
    }

    static void menuHapusAnggota(Scanner inputAnggota, DataPerpus perpus) {
        System.out.print("Kode anggota yang dihapus: ");
        String kode = inputAnggota.nextLine();
        boolean berhasil = perpus.hapusAnggota(kode);
        System.out.println(berhasil ? "Anggota berhasil dihapus." : "Anggota tidak ditemukan.");
    }

    static void menuPinjamBuku(Scanner inputBuku, DataPerpus perpus) {
        System.out.print("Kode anggota: ");
        String kodeAnggota = inputBuku.nextLine();
        System.out.print("Kode buku: ");
        String kodeBuku = inputBuku.nextLine();
        System.out.print("Jumlah: ");
        int jumlah = inputInt(inputBuku);
        perpus.pinjamBuku(kodeAnggota, kodeBuku, jumlah);
    }

    static void menuKembalikanBuku(Scanner inputBuku, DataPerpus perpus) {
        System.out.print("Kode anggota: ");
        String kodeAnggota = inputBuku.nextLine();
        System.out.print("Kode buku: ");
        String kodeBuku = inputBuku.nextLine();
        System.out.print("Jumlah: ");
        int jumlah = inputInt(inputBuku);
        perpus.kembalikanBuku(kodeAnggota, kodeBuku, jumlah);
    }

    static void menuCariBerdasarkanKategori(Scanner inputBuku, DataPerpus perpus) {
        System.out.print("Masukkan kategori (Fiksi/Non-Fiksi): ");
        String kategori = inputBuku.nextLine();
        perpus.tampilkanSemuaBuku(kategori);
    }

    static int inputInt(Scanner inputBuku) {
        while (!inputBuku.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            inputBuku.next();
        }
        int nilai = inputBuku.nextInt();
        inputBuku.nextLine(); // buang sisa newline
        return nilai;
    }

    static void isiDataAwal(DataPerpus perpus) {
        perpus.tambahBuku(new BukuJenisFiksi("B001", "Laskar Pelangi", "Andrea Hirata", 5, "Drama"));
        perpus.tambahBuku(new JenisBukuNonFiksi("B002", "Sapiens", "Yuval Noah Harari", 3, "Sejarah"));
        perpus.tambahAnggota(new Anggota("A001", "Kaayus", "081245632190"));
    }
}