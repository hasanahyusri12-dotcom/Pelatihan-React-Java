package uts;

public class DataBuku implements BukudiPinjam {
    private String kodeBuku;
    private String judul;
    private String penulis;
    private String kategori;
    private int tahunTerbit;
    private boolean tersedia;

    public DataBuku(String kodeBuku, String judul, String penulis, String kategori, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = true; 
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public void pinjam() {
        this.tersedia = false;
    }

    @Override
    public void kembalikan() {
        this.tersedia = true;
    }

    public void tampilkanData() {
        String status = tersedia ? "Tersedia" : "Dipinjam";
        System.out.println(kodeBuku + " | " + judul + " | " + penulis + " | " + kategori + " | " + tahunTerbit + " | " + status);
    }
}