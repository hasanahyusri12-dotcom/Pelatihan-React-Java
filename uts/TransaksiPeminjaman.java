package uts;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TransaksiPeminjaman {
    private String kodeTransaksi;
    private Anggota anggota;
    private DataBuku buku;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private boolean sudahDikembalikan;
    private long lamaPeminjaman;
    private long keterlambatan;  
    private int denda;           

    public TransaksiPeminjaman(String kodeTransaksi, Anggota anggota, DataBuku buku, LocalDate tanggalPinjam) {
        this.kodeTransaksi = kodeTransaksi;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = null;
        this.sudahDikembalikan = false;
        this.lamaPeminjaman = 0;
        this.keterlambatan = 0;
        this.denda = 0;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public DataBuku getBuku() {
        return buku;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public boolean isSudahDikembalikan() {
        return sudahDikembalikan;
    }

    public long getLamaPeminjaman() {
        return lamaPeminjaman;
    }

    public long getKeterlambatan() {
        return keterlambatan;
    }

    public int getDenda() {
        return denda;
    }

    // kode proses pengembalian buku 
    public void prosesPengembalian(LocalDate tglKembali, int batasPeminjaman, int dendaPerHari) {
        this.tanggalKembali = tglKembali;
        this.sudahDikembalikan = true;
        this.lamaPeminjaman = ChronoUnit.DAYS.between(tanggalPinjam, tglKembali);

        long telat = lamaPeminjaman - batasPeminjaman;
        if (telat > 0) {
            this.keterlambatan = telat;
            this.denda = (int) (telat * dendaPerHari);
        } else {
            this.keterlambatan = 0;
            this.denda = 0;
        }
    }

    public void tampilkanData() {
        String statusKembali = tanggalKembali == null ? "Belum Kembali" : tanggalKembali.toString();
        System.out.println(kodeTransaksi + " | " + buku.getJudul() + " | " + anggota.getNama()
                + " | Pinjam: " + tanggalPinjam + " | Kembali: " + statusKembali
                + " | Status: " + (sudahDikembalikan ? "Selesai" : "Aktif")
                + " | Denda: Rp" + denda);
    }
}