package uts;

import java.util.Scanner;

// ==========================================================
// A WAHYU INI CONTOH KODE UNTUK INPUT YAH BIAR GAK PUSING :)1

//
// Kode Buku      : BK001
// ID Anggota     : A001
// Kode Transaksi : TRS2
// ID Kartu Anggota : KRT1
//                
// ================

public class Main {
    private Scanner input;
    private KelolaPerpustakaan perpustakaan;

    public Main() {
        this.input = new Scanner(System.in);
        this.perpustakaan = new KelolaPerpustakaan(input);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.jalankan();
    }

    private void jalankan() {
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("SISTEM MANAJEMEN PERPUSTAKAAN");
            System.out.println("========================================");
            System.out.println("1. Kelola Buku");
            System.out.println("2. Kelola Anggota");
            System.out.println("3. Peminjaman Buku");
            System.out.println("4. Pengembalian Buku");
            System.out.println("5. Cari Data");
            System.out.println("6. Lihat Transaksi");
            System.out.println("7. Kelola Staf");
            System.out.println("8. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine().trim();

            switch (pilihan) {
                case "1":
                    menuBuku();
                    break;
                case "2":
                    menuAnggota();
                    break;
                case "3":
                    perpustakaan.pinjamBuku();
                    break;
                case "4":
                    perpustakaan.kembalikanBuku();
                    break;
                case "5":
                    perpustakaan.menuPencarian();
                    break;
                case "6":
                    perpustakaan.lihatTransaksi();
                    break;
                case "7":
                    menuStaf();
                    break;
                case "8":
                    lanjut = false;
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }

    private void menuBuku() {
        System.out.println("");
        System.out.println("--- Kelola Buku ---");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tampilkan Buku");
        System.out.println("3. Ubah Buku");
        System.out.println("4. Hapus Buku");
        System.out.print("Pilih: ");
        String pilihan = input.nextLine().trim();

        switch (pilihan) {
            case "1":
                perpustakaan.tambahBuku();
                break;
            case "2":
                perpustakaan.tampilkanBuku();
                break;
            case "3":
                perpustakaan.ubahBuku();
                break;
            case "4":
                perpustakaan.hapusBuku();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private void menuAnggota() {
        System.out.println("");
        System.out.println("--- Kelola Anggota ---");
        System.out.println("1. Tambah Anggota");
        System.out.println("2. Tampilkan Anggota");
        System.out.println("3. Ubah Anggota");
        System.out.println("4. Hapus Anggota");
        System.out.print("Pilih: ");
        String pilihan = input.nextLine().trim();

        switch (pilihan) {
            case "1":
                perpustakaan.tambahAnggota();
                break;
            case "2":
                perpustakaan.tampilkanAnggota();
                break;
            case "3":
                perpustakaan.ubahAnggota();
                break;
            case "4":
                perpustakaan.hapusAnggota();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private void menuStaf() {
        System.out.println("");
        System.out.println("--- Kelola Staf ---");
        System.out.println("1. Tambah Staf");
        System.out.println("2. Tampilkan Staf");
        System.out.print("Pilih: ");
        String pilihan = input.nextLine().trim();

        switch (pilihan) {
            case "1":
                perpustakaan.tambahStaf();
                break;
            case "2":
                perpustakaan.tampilkanStaf();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
}