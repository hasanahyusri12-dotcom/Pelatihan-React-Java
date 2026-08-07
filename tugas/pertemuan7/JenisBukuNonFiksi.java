package tugas.pertemuan7;

public class JenisBukuNonFiksi extends Buku {
    private String subjek;

    public JenisBukuNonFiksi(String kode, String judul, String pengarang, int stok, String subjek) {
        super(kode, judul, pengarang, stok);
        this.subjek = subjek;
    }

    public String getSubjek() { return subjek; }
    public void setSubjek(String subjek) { this.subjek = subjek; }

    @Override
    public String getKategori() {
        return "Non-Fiksi (" + subjek + ")";
    }
}