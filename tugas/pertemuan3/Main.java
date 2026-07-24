package tugas.pertemuan3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    static HashMap<String, Integer> kategoriKendaraan = new HashMap<>();
    static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {
        kategoriKendaraan.put("Mobil", 0);
        kategoriKendaraan.put("Motor", 0);

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = inputInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    ubahData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    tampilkanStatistik();
                    break;
                case 0:
                    System.out.println("Program selesai. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
            System.out.println(); 
        } while (pilihan != 0);

        scanner.close();
    }

    // ==========================================================
    // MENU
    // ==========================================================
    static void tampilkanMenu() {
        System.out.println("===================================");
        System.out.println("   SISTEM MANAJEMEN DATA KENDARAAN");
        System.out.println("===================================");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Lihat Seluruh Data");
        System.out.println("3. Ubah Data Kendaraan");
        System.out.println("4. Hapus Data Kendaraan");
        System.out.println("5. Statistik Kendaraan");
        System.out.println("0. Keluar");
        System.out.println("===================================");
    }

    // ==========================================================
    // 1. TAMBAH DATA (Create)
    // ==========================================================
    static void tambahData() {
        System.out.println("--- Tambah Data Kendaraan ---");
        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        int jenis = inputInt("Pilihan: ");

        if (jenis != 1 && jenis != 2) {
            System.out.println("Jenis tidak valid. Data batal ditambahkan.");
            return; 
        }

        String kode = inputKodeBaru();
        String merk = inputString("Merk: ");
        String warna = inputString("Warna: ");
        double harga = inputDouble("Harga: ");
        int tahun = inputInt("Tahun Produksi: ");

        if (jenis == 1) {
            int jumlahPintu = inputInt("Jumlah Pintu: ");
            String transmisi = inputString("Transmisi (Manual/Matic): ");

            Mobil mobil = new Mobil(kode, merk, warna, harga, tahun, jumlahPintu, transmisi);

            daftarKendaraan.add(mobil);

            kategoriKendaraan.put("Mobil", kategoriKendaraan.get("Mobil") + 1);
        } else {
            int cc = inputInt("Kapasitas Mesin (cc): ");
            String jenisMotor = inputString("Tipe Motor (Matic/Manual/Sport): ");

            Motor motor = new Motor(kode, merk, warna, harga, tahun, cc, jenisMotor);
            daftarKendaraan.add(motor);

            kategoriKendaraan.put("Motor", kategoriKendaraan.get("Motor") + 1);
        }

        System.out.println("Data berhasil ditambahkan!");
    }

    // ==========================================================
    // 2. LIHAT DATA (Read)
    // ==========================================================
    static void lihatData() {
        System.out.println("--- Daftar Seluruh Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKendaraan.get(i).tampilInfo());
        }
    }

    // ==========================================================
    // 3. UBAH DATA (Update)
    // ==========================================================
    static void ubahData() {
        System.out.println("--- Ubah Data Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }

        String kode = inputString("Masukkan kode kendaraan yang mau diubah: ");
        int index = cariIndexByKode(kode);

        if (index == -1) {
            System.out.println("Data dengan kode " + kode + " tidak ditemukan.");
            return;
        }

        Kendaraan k = daftarKendaraan.get(index);
        System.out.println("Data saat ini: " + k.tampilInfo());
        System.out.println("Masukkan data baru (kode tidak bisa diubah):");

        k.setMerk(inputString("Merk baru: "));
        k.setWarna(inputString("Warna baru: "));
        k.setHarga(inputDouble("Harga baru: "));
        k.setTahunProduksi(inputInt("Tahun Produksi baru: "));

        if (k instanceof Mobil) {
            Mobil mobil = (Mobil) k; 
            mobil.setJumlahPintu(inputInt("Jumlah Pintu baru: "));
            mobil.setjenisKendaran(inputString("Jenis Kendaraan baru (Sedan/SUV/Hatchback): "));
        } else if (k instanceof Motor) {
            Motor motor = (Motor) k; // casting: anggap k sebagai Motor
            motor.setKapasitasMesin(inputInt("Kapasitas Mesin baru (cc): "));
            motor.setJenisMotor(inputString("Tipe Motor baru (Matic/Manual/Sport): "));
        }

        System.out.println("Data berhasil diubah!");
    }

    // ==========================================================
    // 4. HAPUS DATA (Delete)
    // ==========================================================
    static void hapusData() {
        System.out.println("--- Hapus Data Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }

        String kode = inputString("Masukkan kode kendaraan yang mau dihapus: ");
        int index = cariIndexByKode(kode);

        if (index == -1) {
            System.out.println("Data dengan kode " + kode + " tidak ditemukan.");
            return;
        }

        Kendaraan k = daftarKendaraan.get(index);
        String jenis = k.getJenis();

        daftarKendaraan.remove(index); 
        kategoriKendaraan.put(jenis, kategoriKendaraan.get(jenis) - 1); 

        System.out.println("Data dengan kode " + kode + " berhasil dihapus.");
    }

    // ==========================================================
    // 5. STATISTIK (fitur tambahan, nilai plus)
    // ==========================================================
    static void tampilkanStatistik() {
        System.out.println("--- Statistik Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }

        System.out.println("Jumlah Mobil : " + kategoriKendaraan.get("Mobil"));
        System.out.println("Jumlah Motor : " + kategoriKendaraan.get("Motor"));
        System.out.println("Total Kendaraan : " + daftarKendaraan.size());

        double totalHarga = 0;
        for (Kendaraan k : daftarKendaraan) {
            totalHarga += k.getHarga();
        }
        double rataRata = totalHarga / daftarKendaraan.size();

        System.out.println("Total Harga Seluruh Kendaraan : " + (long) totalHarga);
        System.out.println("Rata-rata Harga Kendaraan : " + (long) rataRata);
    }

    // ==========================================================
    // METHOD BANTUAN (helper) - dipanggil dari method-method di atas
    // ==========================================================

    static int cariIndexByKode(String kode) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            if (daftarKendaraan.get(i).getKodeKendaraan().equalsIgnoreCase(kode)) {
                return i;
            }
        }
        return -1; 
    }

    static String inputKodeBaru() {
        String kode;
        while (true) {
            kode = inputString("Kode Kendaraan: ");
            if (cariIndexByKode(kode) != -1) {
                System.out.println("Kode sudah dipakai, masukkan kode lain.");
            } else if (kode.isEmpty()) {
                System.out.println("Kode tidak boleh kosong.");
            } else {
                break; 
            }
        }
        return kode;
    }

    static String inputString(String label) {
        System.out.print(label);
        return scanner.nextLine().trim();
    }

    static int inputInt(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat, coba lagi.");
            }
        }
    }

    static double inputDouble(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                double nilai = Double.parseDouble(input);
                if (nilai < 0) {
                    System.out.println("Harga tidak boleh negatif, coba lagi.");
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka, coba lagi.");
            }
        }
    }
}