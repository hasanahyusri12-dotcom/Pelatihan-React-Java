package tugas.pertemuan7;

// interface untuk objek yang bisa dipinjam & dikembalikan
public interface Peminjam {
    boolean pinjam(int jumlah);
    boolean kembalikan(int jumlah);
}