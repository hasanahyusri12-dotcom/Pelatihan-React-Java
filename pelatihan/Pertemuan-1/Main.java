import java.io.*;                    // Import semua class dari package io (Input/Output)
import java.util.*;                  // Import semua class dari package util (termasuk Scanner & ArrayList)
import java.util.ArrayList;          // Import khusus ArrayList (meski sudah ada di java.util.*)

public class Main {                  // Deklarasi class utama, nama harus sama dengan nama file

    // =============================================
    // VARIABEL FINAL (Konstanta) - Milik Class
    // =============================================
    final static String UNIVERSITAS = "Universitas XYZ";  // Variabel final static (konstanta)
    final int KONSTAN = 100;                              // Variabel final instance

    public static void main(String[] args) throws IOException {  
        // Method utama yang pertama kali dijalankan oleh JVM
        // throws IOException karena kita akan pakai BufferedReader

        // Membuat objek untuk input
        Scanner input = new Scanner(System.in);           // Membuat objek Scanner untuk input mudah
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // Membuat BufferedReader (cara lama input)

        System.out.println("=========================================");
        System.out.println("   MATERI 1 - PENGENALAN JAVA");
        System.out.println("=========================================\n");

        // =============================================
        // 1. METHOD OUTPUT
        // =============================================
        System.out.println("=== METHOD OUTPUT ===");     // Mencetak teks + baris baru
        System.out.println("Menggunakan println()");      // println = print + new line
        
        System.out.print("Menggunakan print() - ");      // print() tidak menambah baris baru
        System.out.print("masih di baris yang sama\n");  // \n = pindah baris manual
        
        int umur = 20;                                    // Deklarasi variabel bertipe int
        System.out.printf("Contoh printf -> Umur saya %d tahun\n\n", umur); 
        // printf untuk format string (%d = integer)

        // =============================================
        // 2. TIPE DATA PRIMITIF
        // =============================================
        System.out.println("=== TIPE DATA PRIMITIF ===");
        
        char golonganDarah = 'A';        // Tipe char = 1 karakter, pakai single quote
        int usia = 20;                   // Tipe int = bilangan bulat
        double tinggi = 1.74;            // Tipe double = bilangan desimal (lebih presisi)
        boolean menikah = false;         // Tipe boolean = true atau false
        
        System.out.println("Golongan Darah : " + golonganDarah);
        System.out.println("Usia           : " + usia);
        System.out.println("Tinggi         : " + tinggi);
        System.out.println("Menikah        : " + menikah + "\n");

        // =============================================
        // 3. TIPE DATA KOMPOSIT - STRING
        // =============================================
        System.out.println("=== TIPE DATA STRING ===");
        String nama = "Dimas Firmansyah";   // String harus huruf S besar, karena ini class
        
        System.out.println("Nama          : " + nama);
        System.out.println("Panjang       : " + nama.length());        // Method length()
        System.out.println("Uppercase     : " + nama.toUpperCase());   // Ubah ke huruf besar
        System.out.println("Lowercase     : " + nama.toLowerCase());   // Ubah ke huruf kecil
        System.out.println("Karakter ke-5 : " + nama.charAt(5) + "\n"); // Ambil karakter ke-5

        // =============================================
        // 4. ARRAY
        // =============================================
        System.out.println("=== ARRAY ===");
        int[] angka = {1, 2, 3, 4, 5};           // Array dengan inisialisasi langsung
        
        String[] mahasiswa = new String[3];      // Membuat array kosong ukuran 3
        mahasiswa[0] = "Dilan";                  // Isi index 0
        mahasiswa[1] = "Milea";
        mahasiswa[2] = "Azka";
        
        System.out.println("Angka index 2 : " + angka[2]);
        System.out.println("Mahasiswa[1]  : " + mahasiswa[1] + "\n");

        // =============================================
        // 5. ARRAYLIST
        // =============================================
        System.out.println("=== ARRAYLIST ===");
        ArrayList<String> listNama = new ArrayList<>();  // Membuat ArrayList kosong
        
        listNama.add("Dilan");      // Menambahkan data
        listNama.add("Milea");
        listNama.add("Azka");
        
        System.out.println("List Nama     : " + listNama);
        System.out.println("Index 0       : " + listNama.get(0));   // Mengambil data
        System.out.println("Jumlah data   : " + listNama.size() + "\n"); // Ukuran list

        // =============================================
        // 6. VARIABEL LOKAL
        // =============================================
        System.out.println("=== VARIABEL LOKAL ===");
        int variabelLokal = 999;          // Variabel lokal hanya bisa dipakai di dalam method ini
        System.out.println("Variabel Lokal : " + variabelLokal + "\n");

        // =============================================
        // 7. VARIABEL FINAL
        // =============================================
        System.out.println("=== VARIABEL FINAL ===");
        Main obj = new Main();                    // Membuat objek dari class Main
        System.out.println("Konstanta      : " + obj.KONSTAN);
        System.out.println("Universitas    : " + UNIVERSITAS + "\n");

        // =============================================
        // 8. INPUT DENGAN SCANNER
        // =============================================
        System.out.println("=== INPUT DENGAN SCANNER ===");
        System.out.print("Masukkan nama Anda : ");
        String namaInput = input.nextLine();      // Membaca input string satu baris
        
        System.out.print("Masukkan umur Anda : ");
        int umurInput = input.nextInt();          // Membaca input bertipe integer
        
        System.out.println("\n=== DATA YANG DIMASUKKAN ===");
        System.out.println("Nama : " + namaInput);
        System.out.println("Umur : " + umurInput + " tahun");

        input.close();        // Menutup Scanner (good practice)

        System.out.println("\n=========================================");
        System.out.println("Program Selesai. Terima Kasih!");
        System.out.println("=========================================");
    }
}