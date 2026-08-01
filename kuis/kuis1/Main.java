package kuis.kuis1;

public class Main {
    public static void main(String[] args) {
        AnggotaKhusus khusus = new AnggotaKhusus("Kaayus", "A001", "21051001");
        AnggotaUmum umum = new AnggotaUmum("Albian", "A002", "Wiraswasta");

        System.out.println("--- Data Anggota Khusus ---");
        khusus.tampilkanInfo();
        System.out.println("NIM          : " + khusus.getNim());

        System.out.println();
        System.out.println("--- Data Anggota Umum ---");
        umum.tampilkanInfo();
        System.out.println("Pekerjaan    : " + umum.getPekerjaan());

        System.out.println();
        System.out.println("--- Aktivitas Peminjaman ---");
        khusus.pinjamBuku("Pemrograman Java Dasar");
        umum.pinjamBuku("Sejarah Indonesia");
        khusus.kembalikanBuku("Pemrograman Java Dasar");
        umum.kembalikanBuku("Sejarah Indonesia");

        System.out.println();
        System.out.println("--- Perhitungan Denda ---");
        System.out.println("Denda Anggota Khusus (5 hari terlambat) : Rp" + khusus.hitungDenda(5));
        System.out.println("Denda Anggota Umum (5 hari terlambat)   : Rp" + umum.hitungDenda(5));

        System.out.println();
        System.out.println("--- hitungDenda(overloading) ---");
        System.out.println("Denda Khusus tanpa tambahan      : Rp" + khusus.hitungDenda(5));
        System.out.println("Denda Khusus + denda kerusakan   : Rp" + khusus.hitungDenda(5, 2000));
    }
}