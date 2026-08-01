package kuis.kuis1;

public class AnggotaKhusus extends Anggota implements Pinjam {
    private String nim;
    private static final double denda_perhari = 500;

    public AnggotaKhusus(String nama, String idAnggota, String nim) {
        super(nama, idAnggota);
        this.nim = nim;
    }

    @Override
    public double hitungDenda(int hariTerlambat) {
        return hariTerlambat * denda_perhari;
    }

    @Override
    public void pinjamBuku(String judulBuku) {
        System.out.println(nama + " (Khusus) meminjam buku: " + judulBuku);
    }

    @Override
    public void kembalikanBuku(String judulBuku) {
        System.out.println(nama + " (Khusus) mengembalikan buku: " + judulBuku);
    }

    public String getNim() {
        return nim;
    }
}