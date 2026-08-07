package tugas.pertemuan7;

public class BukuJenisFiksi extends Buku {
    private String genre;

    public BukuJenisFiksi(String kode, String judul, String pengarang, int stok, String genre) {
        super(kode, judul, pengarang, stok);
        this.genre = genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String getKategori() {
        return "Fiksi (" + genre + ")";
    }
}