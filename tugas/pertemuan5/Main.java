package tugas.pertemuan5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KendaraanService service = new KendaraanService();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM MANAJEMEN DATA KENDARAAN =====");
            System.out.println("1. Tambah Data Mobil");
            System.out.println("2. Tambah Data Motor");
            System.out.println("3. Lihat Seluruh Data");
            System.out.println("4. Ubah Data Kendaraan");
            System.out.println("5. Hapus Data Kendaraan");
            System.out.println("6. Cek Jadwal & Kondisi Perawatan Semua Kendaraan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Kode Kendaraan: ");
                    String kodeMobil = scanner.nextLine();
                    System.out.print("Merk: ");
                    String merkMobil = scanner.nextLine();
                    System.out.print("Warna: ");
                    String warnaMobil = scanner.nextLine();
                    System.out.print("Harga: ");
                    double hargaMobil = Double.parseDouble(scanner.nextLine());
                    System.out.print("Jumlah Pintu: ");
                    int jumlahPintu = Integer.parseInt(scanner.nextLine());
                    service.tambahKendaraan(kodeMobil, merkMobil, warnaMobil, hargaMobil, jumlahPintu);
                    break;
                case 2:
                    System.out.print("Kode Kendaraan: ");
                    String kodeMotor = scanner.nextLine();
                    System.out.print("Merk: ");
                    String merkMotor = scanner.nextLine();
                    System.out.print("Warna: ");
                    String warnaMotor = scanner.nextLine();
                    System.out.print("Harga: ");
                    double hargaMotor = Double.parseDouble(scanner.nextLine());
                    System.out.print("Jenis Motor (Matic/Sport/Bebek): ");
                    String jenisMotor = scanner.nextLine();
                    service.tambahKendaraan(kodeMotor, merkMotor, warnaMotor, hargaMotor, jenisMotor);
                    break;
                case 3:
                    service.lihatSemuaData();
                    break;
                case 4:
                    System.out.print("Kode Kendaraan yang diubah: ");
                    String kodeUbah = scanner.nextLine();
                    System.out.print("Merk Baru: ");
                    String merkBaru = scanner.nextLine();
                    System.out.print("Warna Baru: ");
                    String warnaBaru = scanner.nextLine();
                    System.out.print("Harga Baru: ");
                    double hargaBaru = Double.parseDouble(scanner.nextLine());
                    service.ubahData(kodeUbah, merkBaru, warnaBaru, hargaBaru);
                    break;
                case 5:
                    System.out.print("Kode Kendaraan yang dihapus: ");
                    String kodeHapus = scanner.nextLine();
                    service.hapusData(kodeHapus);
                    break;
                case 6:
                    service.cekPerawatanSemua();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}