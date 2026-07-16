package tugas.pertemuan2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        NilaiService nilaiService = new NilaiService();

        System.out.println("=================================================");
        System.out.println(" SISTEM PENDATAAN NILAI MAHASISWA");
        System.out.println("=================================================");

        System.out.print("Masukkan jumlah mahasiswa yang akan diinput: ");
        int jumlah = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= jumlah; i++) {
            System.out.println("");
            System.out.println("Data Mahasiswa ke-" + i);

            System.out.print("NIM   : ");
            String nim = input.nextLine();

            System.out.print("Nama  : ");
            String nama = input.nextLine();

            System.out.print("Nilai Tugas : ");
            double nilaiTugas = Double.parseDouble(input.nextLine());

            System.out.print("Nilai UTS   : ");
            double nilaiUTS = Double.parseDouble(input.nextLine());

            System.out.print("Nilai UAS   : ");
            double nilaiUAS = Double.parseDouble(input.nextLine());

            Mahasiswa mhs = new Mahasiswa(nim, nama, nilaiTugas, nilaiUTS, nilaiUAS);
            daftarMahasiswa.add(mhs);
        }

        System.out.println("");
        System.out.println("=================================");
        System.out.println("HASIL DATA MAHASISWA");
        System.out.println("=================================");

        for (Mahasiswa mhs : daftarMahasiswa) {
            double nilaiAkhir = nilaiService.hitungNilaiAkhir(mhs.getNilaiTugas(), mhs.getNilaiUTS(), mhs.getNilaiUAS());
            char grade = NilaiService.tentukanGrade(nilaiAkhir);
            String status = NilaiService.tentukanStatusKelulusan(nilaiAkhir);

            System.out.println("NIM         : " + mhs.getNim());
            System.out.println("Nama        : " + mhs.getNama());
            System.out.println("Nilai Akhir : " + nilaiAkhir);
            System.out.print("Grade       : " + grade + " -> ");
            NilaiService.tampilkanDeskripsiGrade(grade);
            System.out.println("Status      : " + status);
            System.out.println("---------------------------------");
        }

        System.out.println("");
        System.out.println("Program selesai. Terima kasih!");

        input.close();
    }
}