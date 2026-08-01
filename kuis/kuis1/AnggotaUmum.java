package kuis.kuis1;

public class AnggotaUmum extends Anggota implements Pinjam {
    private String pekerjaan;
    private static final double denda_perhari = 1000;

    public AnggotaUmum(String nama, String idAnggota, String pekerjaan) {
        super(nama, idAnggota);
        this.pekerjaan = pekerjaan;
    }

    @Override
    public double hitungDenda(int hariTerlambat) {
        return hariTerlambat * denda_perhari;
    }

    @Override
    public void pinjamBuku(String judulBuku) {
        System.out.println(nama + " (Umum) meminjam buku: " + judulBuku);
    }

    @Override
    public void kembalikanBuku(String judulBuku) {
        System.out.println(nama + " (Umum) mengembalikan buku: " + judulBuku);
    }

    public String getPekerjaan() {
        return pekerjaan;
    }
}