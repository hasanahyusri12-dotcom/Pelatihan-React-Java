package tugas.pertemuan7;

public abstract class Buku implements Peminjam {
    private String kode;
    private String judul;
    private String pengarang;
    private int stok;

    public Buku(String kode, String judul, String pengarang, int stok) {
        this.kode = kode;
        this.judul = judul;
        this.pengarang = pengarang;
        this.stok = stok;
    }

    // encapsulation - getter & setter
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getPengarang() { return pengarang; }
    public void setPengarang(String pengarang) { this.pengarang = pengarang; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    // abstract method, wajib di-override tiap class turunan
    public abstract String getKategori();

    // method overloading: pinjam() tanpa parameter, default 1 buku
    public boolean pinjam() {
        return pinjam(1);
    }

    // implementasi method dari interface Peminjamable
    @Override
    public boolean pinjam(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah pinjam tidak valid.");
            return false;
        }
        if (stok < jumlah) {
            System.out.println("Stok buku tidak mencukupi.");
            return false;
        }
        stok -= jumlah;
        return true;
    }

    @Override
    public boolean kembalikan(int jumlah) {
        if (jumlah <= 0) return false;
        stok += jumlah;
        return true;
    }

    public void tampilkanInfo() {
        System.out.println(kode + " | " + judul + " | " + pengarang + " | Stok: " + stok + " | " + getKategori());
    }
}